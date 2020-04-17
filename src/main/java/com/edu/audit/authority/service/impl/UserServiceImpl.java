package com.edu.audit.authority.service.impl;

import com.edu.audit.authority.dao.SysUserMapper;
import com.edu.audit.authority.domain.SysUser;
import com.edu.audit.authority.service.UserService;
import com.edu.audit.redis.service.RedisService;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    @Autowired
    RedisService redisService;

    @Override
    public PageResult queryUser(Integer pageNum, Integer pageSize) {
        return PageUtils.getPageResult(pageNum, pageSize, getPageInfo(pageNum, pageSize));
    }

    @Override
    public SysUser selectByPrimaryKey(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUser login(String username, String password) {
        return sysUserMapper.login(username, password);
    }

    @Override
    public Integer register(SysUser sysUser) {
        String code = redisService.get(sysUser.getEmail());
        if (!sysUser.getCode().equals(code)) {
            return null;
        }
        String salt = UUID.randomUUID().toString();
        Object md5Password = new SimpleHash("MD5", sysUser.getPassword(), ByteSource.Util.bytes(salt), 1024);
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        sysUser.setUserId(UUID.randomUUID().toString());
        sysUser.setCreateBy(name);
        sysUser.setUpdateBy(name);
        sysUser.setSalt(salt);
        sysUser.setPassword(md5Password.toString());
        return sysUserMapper.insert(sysUser);
    }

    private PageInfo<SysUser> getPageInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> projects = sysUserMapper.selectAllUser();
        return new PageInfo<SysUser>(projects);
    }

}
