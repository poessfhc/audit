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
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
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
     * @param authenticationToken token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        SysUser user = sysUserMapper.getUserByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName()
        );
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);
        return simpleAuthenticationInfo;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
