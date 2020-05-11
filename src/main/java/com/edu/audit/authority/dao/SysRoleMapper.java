package com.edu.audit.authority.dao;

import com.edu.audit.authority.domain.SysRole;
import com.edu.audit.authority.domain.SysUserRole;
import com.edu.audit.authority.dto.MenuNode;
import com.edu.audit.authority.dto.MenuTree;
import com.edu.audit.authority.dto.RoleMenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    int addRole(SysUserRole sysUserRole);

    int deleteRole(SysUserRole sysUserRole);

    List<SysRole> selectAllRole();

    List<String> selectRole();

    List<String> queryRoleByUserId(String userId);

    List<MenuTree> queryMenuTree();

    List<MenuNode> queryMenuNode(String menuId);

    List<MenuTree> queryMenuTreeByRoleId(String roleId);

    List<MenuNode> queryMenuNodeByRoleId(String roleId);

    int deleteRoleTreeByRoleId(String roleId);

    int deleteUserRoleByUserId(String userId);

    String queryRoleIdByRemark(String remark);

    int addRoleTree(List<RoleMenuDto> roleMenuDtos);

    int addUserRole(String userId,String roleId);
}