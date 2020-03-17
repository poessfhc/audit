package com.edu.audit.authority.service.impl;

import com.edu.audit.authority.service.EmailService;
import com.edu.audit.redis.service.RedisService;
import com.edu.audit.utils.EmailCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.Writer;

/**
 * @ClassName: EmailServiceImpl
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/2/16 12:23
 * @Version: v1.0
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String sendMailAddress;
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Autowired
    RedisService redisService;
    //设置失效时间600秒
    private static long CODE_EXPIRE_SECONDS = 600;

    @Override
    public void sendEmailCode(String emailAddress) {
        String resultCode = EmailCodeUtils.achieveCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendMailAddress);
        message.setTo(emailAddress);
        message.setSubject("验证码");
        message.setText("【Vince审计】验证码是"+resultCode+"（有效时间6分钟）");
        javaMailSender.send(message);
        //清除未失效的key对应的value值
        redisService.remove(emailAddress);
        //缓存新的key-value值
        redisService.set(emailAddress,resultCode);
        //设置过期时间
        redisService.expire(emailAddress,CODE_EXPIRE_SECONDS);
    }
}
