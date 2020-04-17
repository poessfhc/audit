package com.edu.audit.authority.controller;

import com.edu.audit.authority.domain.SysUser;
import com.edu.audit.authority.service.EmailService;
import com.edu.audit.authority.service.MenuService;
import com.edu.audit.authority.service.UserService;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Description: 用户注册以及操作模块
 * @Author: Vince
 * @Date: 2020/2/15 16:37
 * @Version: v1.0
 */
@RestController
@RequestMapping("/admin")
@Api(value = "admin操作")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;
    @Autowired
    MenuService menuService;

    @GetMapping("/queryUser")
    public Result queryUserList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = new Result(200, "查询成功");
        result.putData("userList", userService.queryUser(pageNum, pageSize));
        return result;
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    @RequiresPermissions("user:create")
    public Result register(@RequestBody SysUser sysUser) {
        Integer isSuccess = userService.register(sysUser);
        Result result;
        if (isSuccess == null) {
            result = new Result(0, "验证码错误");
            result.putData("flag", isSuccess);
            return result;
        }
        result = new Result(0, "注册成功");
        result.putData("flag", isSuccess);
        return result;
    }

    @GetMapping("/sendCodeEmail")
    @ApiOperation("发送邮箱验证码")
    @RequiresPermissions("user:create")
    public Result sendCodeEmail(@RequestParam String emailAddress) {
        emailService.sendEmailCode(emailAddress);
        Result result = new Result(1, "发送成功");
        return result;
    }

    @GetMapping("/currentUser")
    @ApiOperation("当前用户")
    @RequiresPermissions("user:create")
    public Result queryCurrentUser() {
        Object o = SecurityUtils.getSubject().getPrincipal();
        Result result = new Result(200, "查询成功");
        result.putData("currentUser", o);
        return result;
    }

    @GetMapping("/queryControlTypeList")
    @ApiOperation("查询用户菜单")
    public Result queryControlTypeList() {
        Result result = new Result(200, "查询成功");
        result.putData("data", menuService.queryControlTypeList());
        return result;
    }
}
