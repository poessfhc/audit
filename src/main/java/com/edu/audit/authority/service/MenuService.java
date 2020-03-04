package com.edu.audit.authority.service;

import com.edu.audit.authority.domain.SysMenu;
import com.edu.audit.authority.dto.MenuDto;

import java.util.List;

/**
 * @ClassName: MenuService
 * @Description: 菜单服务接口层
 * @Author: Vince
 * @Date: 2020/3/1 13:10
 * @Version: v1.0
 */
public interface MenuService {
    /**
     * 查询一级菜单
     */
    List<SysMenu> queryMenuTypeList();

    /**
     * 通过父类id查询二级按钮
     *
     */
    List<MenuDto> queryControlTypeList();
}
