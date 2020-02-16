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
     * @param id 主键id
     * @return 查询到的用户实体
     * */
    SysUser selectByPrimaryKey(String id);
    /**
     * User登录查询
     * @param username 用户名
     * @param password 密码
     * @return 校验是否通过认证
     * */
    SysUser login(String username, String password);
    /**
     * 用户注册
     * @param sysUser 整个用户实体类
     * @return  返回注册是否成功
     * */
    Integer register(SysUser sysUser);
}
