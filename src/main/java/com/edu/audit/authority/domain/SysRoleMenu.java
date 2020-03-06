package com.edu.audit.authority.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: SysRoleMenu
 * @Description: 角色菜单中间表
 * @Author: Vince
 * @Date: 2020/2/21 12:53
 * @Version: v1.0
 */
@Data
@ApiModel("角色菜单中间表")
public class SysRoleMenu {
    @ApiModelProperty("角色id")
    private String roleId;
    @ApiModelProperty("菜单id")
    private String menuId;
}
