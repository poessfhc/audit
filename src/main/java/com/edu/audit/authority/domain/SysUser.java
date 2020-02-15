package com.edu.audit.authority.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    /**
     * 用户ID
     * */
    private String userId;
    /**
     * 用户名称
     * */
    private String username;
    /**
     * 用户邮箱
     * */
    private String email;
    /**
     * 手机号码
     * */
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     * */
    private String sex;
    /**
     * 密码
     * */
    private String password;
    /**
     * 盐加密
     * */
    private String salt;
    /**
     * 删除标志
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