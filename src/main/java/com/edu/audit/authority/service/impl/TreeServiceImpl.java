package com.edu.audit.authority.service.impl;

import com.edu.audit.authority.dao.SysRoleMapper;
import com.edu.audit.authority.dto.MenuNode;
import com.edu.audit.authority.dto.MenuTree;
import com.edu.audit.authority.dto.RoleMenuDto;
import com.edu.audit.authority.dto.RoleMenuDtos;
import com.edu.audit.authority.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: TreeServiceImpl
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/10 13:56
 * @Version: v1.0
 */
@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<MenuTree> queryTree() {
        List<MenuTree> menuTrees = sysRoleMapper.queryMenuTree();
        List<MenuNode> menuNodes = null;
        for (MenuTree menuTree : menuTrees) {
            menuNodes = sysRoleMapper.queryMenuNode(menuTree.getId());
            menuTree.setChildren(menuNodes);
        }
        return menuTrees;
    }

    @Override
    public List<MenuNode> queryRoleTree(String roleId) {
        List<MenuNode> menuNodes = sysRoleMapper.queryMenuNodeByRoleId(roleId);
        return menuNodes;
    }

    @Override
    public Integer updateRoleTreeByRoleId(RoleMenuDtos roleMenuDtos) {
        sysRoleMapper.deleteRoleTreeByRoleId(roleMenuDtos.getRoleId());
        sysRoleMapper.addRoleTree(roleMenuDtos.getRoleMenuDto());
        return 1;
    }
}
