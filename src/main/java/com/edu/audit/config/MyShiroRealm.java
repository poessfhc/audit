package com.edu.audit.config;


import com.edu.audit.authority.dao.SysMenuMapper;
import com.edu.audit.authority.dao.SysRoleMapper;
import com.edu.audit.authority.dao.SysUserMapper;
import com.edu.audit.authority.domain.SysMenu;
import com.edu.audit.authority.domain.SysRole;
import com.edu.audit.authority.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: MyShiroRealm
 * @Description: 权限授权认证
 * @Author: Vince
 * @Date: 2020/1/17 14:30
 * @Version: v1.0
 */
public class MyShiroRealm extends AuthorizingRealm {
    private  static final transient Logger log = LoggerFactory.getLogger(MyShiroRealm.class);
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 授权
     *
     * @param principalCollection 身份集合
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        List<SysRole> roles = sysRoleMapper.selectByPrimaryKey(user.getUserId());
        List<SysMenu> menus = sysMenuMapper.selectByPrimaryKey(user.getUserId());
        simpleAuthorizationInfo.addRoles(roles.stream().map(SysRole::getRoleName).collect(Collectors.toSet()));
        simpleAuthorizationInfo.addStringPermissions(menus.stream().map(SysMenu::getPerms).collect(Collectors.toSet()));
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param token token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("^^^^^^^^^^^^^^^^^^^^ ITDragon 认证用户身份信息");
        // 获取用户登录账号
        String username = (String) token.getPrincipal();
        // 通过账号查加密后的密码和盐，这里一般从缓存读取
        SysUser userInfo = sysUserMapper.getUserByUsername(username);
        if(null == userInfo){
            return null;
        }
        // 1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        // 2). credentials: 加密后的密码.
        Object credentials = userInfo.getPassword();
        // 3). realmName: 当前 realm 对象的唯一名字. 调用父类的 getName() 方法
        String realmName = getName();
        // 4). credentialsSalt: 盐值. 注意类型是ByteSource
        ByteSource credentialsSalt = ByteSource.Util.bytes(userInfo.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
