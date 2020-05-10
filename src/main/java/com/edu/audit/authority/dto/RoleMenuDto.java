package com.edu.audit.authority.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: RoleMenuDto
 * @Description: 角色菜单中间表
 * @Author: Vince
 * @Date: 2020/5/10 18:51
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@ApiModel("角色菜单中间表")
public class RoleMenuDto {
    private String roleId;
    private String menuId;
}
