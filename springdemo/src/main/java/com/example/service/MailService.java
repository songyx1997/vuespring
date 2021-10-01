package com.example.service;

/**
 * <p>Title: MailService</p>
 * <p>Description: 邮件服务接口</p>
 * @author songy
 * @date 2021/10/2
 */
public interface MailService {
    /**
     * <p>Title: sendMailCode</p>
     * <p>Description: 发送邮箱验证码</p>
     * @param emailAddress 收件人邮箱地址
     */
    void sendMailCode(String emailAddress);
}
