package com.edu.audit.authority.controller;

import com.edu.audit.authority.domain.SysUser;
import com.edu.audit.authority.service.UserService;
import com.edu.audit.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * @ClassName: LoginController
 * @Description: TODO 还需进行修改
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
    public JsonResult login(@RequestParam String username, @RequestParam String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        SecurityUtils.getSubject().login(token);
        //设置session时间
        //SecurityUtils.getSubject().getSession().setTimeout(1000*60*30);
        //token信息
        Subject subject = SecurityUtils.getSubject();
        Serializable tokenId = subject.getSession().getId();
        return new JsonResult(1, "登录认证成功", tokenId);
    }

    @GetMapping("/test")
    public String test() {
        String salt = UUID.randomUUID().toString();
        System.out.println(salt);
        Object md5Password = new SimpleHash("MD5", "admin", ByteSource.Util.bytes(salt), 1024);
        System.out.println(md5Password.toString());
        return "ttt";
    }

}
