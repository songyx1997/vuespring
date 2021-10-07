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
     * <p>Description: </p>
     * @param emailAddress 收件人邮箱地址
     * @return java.lang.String
     */
    String sendMailCode(String emailAddress);
}
