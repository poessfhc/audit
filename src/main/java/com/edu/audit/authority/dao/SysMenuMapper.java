package com.edu.audit.authority.dao;

import com.edu.audit.authority.domain.SysMenu;
import com.edu.audit.authority.domain.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
}