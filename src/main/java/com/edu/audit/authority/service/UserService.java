package com.edu.audit.authority.service;

import com.edu.audit.authority.domain.SysUser;
import com.edu.audit.utils.PageResult;
import com.edu.audit.utils.PageUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: 用户服务层
 * @Author: Vince
 * @Date: 2020/1/17 15:21
 * @Version: v1.0
 */
public interface UserService {
    /**
     * 查询用户列表
     *
     * @param pageNum  当前页
     * @param pageSize 页面大小
     */
    PageResult queryUser(Integer pageNum, Integer pageSize);

    /**
     * 通过主键查询User
     *
     * @param id 主键id
     * @return 查询到的用户实体
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * User登录查询
     *
     * @param username 用户名
     * @param password 密码
     * @return 校验是否通过认证
     */
    SysUser login(String username, String password);

    /**
     * 用户注册
     *
     * @param sysUser 整个用户实体类
     * @return 返回注册是否成功
     */
    Integer register(SysUser sysUser);

    /**
     * 通过用户id更新用户角色
     * @param remark 角色名
     * @param userId 用户id
     */
    Integer updateUserRoleByUserId(String remark,String userId);
}
