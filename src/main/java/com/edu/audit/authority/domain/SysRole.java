package com.edu.audit.authority.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    /**
     * 角色ID
     * */
    private String roleId;
    /**
     * 角色名称
     * */
    private String roleName;
    /**
     * 角色权限字符串
     * */
    private String remark;
    /**
     * 角色状态（0正常 1停用）
     * */
    private String deleteFlag;
    /**
     * 创建者
     * */
    private String createBy;
    /**
     * 创建时间
     * */
    private Date createTime;
    /**
     * 更新者
     * */
    private String updateBy;
    /**
     * 更新时间
     * */
    private Date updateTime;
}