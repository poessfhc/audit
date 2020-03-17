package com.edu.audit.authority.controller;

import com.edu.audit.authority.domain.SysUser;
import com.edu.audit.authority.domain.User;
import com.edu.audit.authority.service.UserService;
import com.edu.audit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * @ClassName: LoginController
 * @Description: 用户登录
 * @Author: Vince
 * @Date: 2020/1/17 15:37
 * @Version: v1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "简单登录测试")
public class LoginController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "简单登录测试接口")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        SecurityUtils.getSubject().login(token);
        //设置session时间
        //SecurityUtils.getSubject().getSession().setTimeout(1000*60*30);
        //token信息
        Subject subject = SecurityUtils.getSubject();
        Serializable tokenId = subject.getSession().getId();
        Result result = new Result(200, "登录成功");
        result.putData("authToken", tokenId);
        return result;
    }

    @GetMapping("/test")
    @RequiresPermissions("user:create")
    public Result test() {
        Result result = new Result(200, "查询");
        return result;
    }

}
