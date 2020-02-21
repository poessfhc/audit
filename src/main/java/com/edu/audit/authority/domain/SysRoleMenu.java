package com.edu.audit.authority.domain;

import lombok.Data;

/**
 * @ClassName: SysRoleMenu
 * @Description: 角色菜单中间表
 * @Author: Vince
 * @Date: 2020/2/21 12:53
 * @Version: v1.0
 */
@Data
public class SysRoleMenu {
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 菜单id
     */
    private String menuId;
}
