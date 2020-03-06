package com.edu.audit.authority.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: SysUserRole
 * @Description: 用户角色中间表
 * @Author: Vince
 * @Date: 2020/2/21 12:48
 * @Version: v1.0
 */
@Data
@ApiModel("用户角色中间表")
public class SysUserRole {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("角色id")
    private String roleId;
}
