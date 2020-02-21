package com.edu.audit.authority.domain;

import lombok.Data;

/**
 * @ClassName: SysUserRole
 * @Description: 用户角色中间表
 * @Author: Vince
 * @Date: 2020/2/21 12:48
 * @Version: v1.0
 */
@Data
public class SysUserRole {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;
}
