package com.edu.audit.authority.dao;

import com.edu.audit.authority.domain.SysMenu;
import com.edu.audit.authority.domain.SysRoleMenu;
import com.edu.audit.authority.dto.MenuDto;
import com.edu.audit.authority.dto.RouterDataItem;
import com.edu.audit.authority.dto.SubMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    int addMenu(SysRoleMenu sysRoleMenu);

    int deleteMenu(SysRoleMenu sysRoleMenu);

    /**
     * 查询一级菜单
     *
     * @return 一级菜单返回数据
     */
    List<SysMenu> queryMenuTypeList();

    /**
     * 查询一级菜单
     *
     * @return 一级菜单返回数据
     */
    List<MenuDto> queryMenuTypeListBy(String username);

    /**
     * 通过父类id查询二级按钮
     *
     * @param parentId 父类id
     * @return 二级菜单返回数据
     */
    List<SubMenu> queryControlTypeList(String parentId);

    /**
     * 查询二级菜单
     *
     * @return 二级菜单返回数据作为路由数据
     */
    List<RouterDataItem> queryRouterList(String username);
}