package com.edu.audit.authority.service;

import com.edu.audit.authority.domain.SysUser;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/1/17 15:21
 * @Version: v1.0
 */
public interface UserService {
    SysUser selectByPrimaryKey(String id);

    SysUser login(String username, String password);
}
