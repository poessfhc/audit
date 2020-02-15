package com.edu.audit.authority.service;

import com.edu.audit.authority.domain.SysUser;

/**
 * @ClassName: UserService
 * @Description: 用户服务层
 * @Author: Vince
 * @Date: 2020/1/17 15:21
 * @Version: v1.0
 */
public interface UserService {
    /**
     * 通过主键查询User
     * */
    SysUser selectByPrimaryKey(String id);
    /**
     * User登录查询
     * */
    SysUser login(String username, String password);
    /**
     * 用户注册
     * */
    Integer register(SysUser sysUser);
}
