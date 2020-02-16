package com.edu.audit.authority.service;

/**
 * @ClassName: EmailService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/2/16 12:22
 * @Version: v1.0
 */
public interface EmailService {
    /**
     * 发送验证码邮件
     * @param emailAddress 收件人地址
     * */
    void sendEmailCode(String emailAddress);
}
