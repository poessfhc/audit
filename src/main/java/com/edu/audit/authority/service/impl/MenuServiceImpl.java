package com.edu.audit.authority.service.impl;

import com.edu.audit.authority.dao.SysMenuMapper;
import com.edu.audit.authority.domain.SysMenu;
import com.edu.audit.authority.dto.MenuDto;
import com.edu.audit.authority.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MenuServiceImpl
 * @Description: 菜单服务接口实现类
 * @Author: Vince
 * @Date: 2020/3/1 13:11
 * @Version: v1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> queryMenuTypeList() {
        return sysMenuMapper.queryMenuTypeList();
    }

    @Override
    public List<MenuDto> queryControlTypeList() {
        String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
        //存放菜单按钮
        List<MenuDto> menuList = sysMenuMapper.queryMenuTypeListBy(currentUser);
        //存放详细菜单以及对应按钮的数据
        for (int i = 0; i < menuList.size(); i++) {
            menuList.get(i).setChildren(sysMenuMapper.queryControlTypeList(menuList.get(i).getMenuId()));
        }
        return menuList;
    }
}
