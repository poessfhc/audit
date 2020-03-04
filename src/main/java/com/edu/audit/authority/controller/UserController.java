package com.edu.audit.authority.controller;

import com.edu.audit.authority.domain.SysUser;
import com.edu.audit.authority.service.EmailService;
import com.edu.audit.authority.service.UserService;
import com.edu.audit.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @PostMapping("/register")
    @ApiOperation("用户注册")
    @RequiresPermissions("user:create")
    public JsonResult register(@RequestBody SysUser sysUser) {
        Integer isSuccess = userService.register(sysUser);
        if (isSuccess == null) {
            return new JsonResult(0, "验证码错误", isSuccess);
        }
        return new JsonResult(1, "注册成功", isSuccess);
    }

    @GetMapping("/sendCodeEmail")
    @ApiOperation("发送邮箱验证码")
    @RequiresPermissions("user:create")
    public JsonResult sendCodeEmail(@RequestParam String emailAddress) {
        emailService.sendEmailCode(emailAddress);
        return new JsonResult(1, "发送成功", "success");
    }
}
