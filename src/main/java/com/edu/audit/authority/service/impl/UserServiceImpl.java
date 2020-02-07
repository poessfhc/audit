package com.edu.audit.authority.service.impl;

import com.edu.audit.authority.dao.SysUserMapper;
import com.edu.audit.authority.domain.SysUser;
import com.edu.audit.authority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/2/7 13:35
 * @Version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByPrimaryKey(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUser login(String username, String password) {
        return sysUserMapper.login(username, password);
    }
}
