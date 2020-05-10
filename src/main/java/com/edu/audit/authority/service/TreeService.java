package com.edu.audit.authority.service;

import com.edu.audit.authority.dto.MenuNode;
import com.edu.audit.authority.dto.MenuTree;
import com.edu.audit.authority.dto.RoleMenuDto;
import com.edu.audit.authority.dto.RoleMenuDtos;

import java.util.List;

/**
 * @ClassName: TreeService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/10 13:56
 * @Version: v1.0
 */
public interface TreeService {
    List<MenuTree> queryTree();

    List<MenuNode> queryRoleTree(String roleId);

    Integer updateRoleTreeByRoleId(RoleMenuDtos roleMenuDtos);
}
