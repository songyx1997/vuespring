package com.example.service.impl;

import com.example.service.MailService;
import com.example.utils.RandomStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>Title: MailServiceImpl</p>
 * <p>Description: 邮件服务实现类</p>
 * @author songy
 * @date 2021/10/2
 */
@Service
public class MailServiceImpl implements MailService {

    private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);

    @Resource
    private JavaMailSender javaMailSender;

    @Async
    @Override
    public void sendMailCode(String emailAddress) {
        String mailCode = RandomStringUtil.randomMailCode();
        LOG.info("生成6位数字验证码:{}", mailCode);
        SimpleMailMessage email = new SimpleMailMessage();
        //邮件标题
        email.setSubject("注册验证码");
        //邮件正文
        StringBuilder emailText = new StringBuilder("尊敬的用户，您好:\n");
        emailText.append("\n本次请求的邮件验证码为：").append(mailCode);
        emailText.append("，本验证码5分钟内有效，请及时输入（请勿泄露此验证码）。\n");
        emailText.append("\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请不要直接回复）");
        email.setText(emailText.toString());
        //收件人邮箱地址
        email.setTo(emailAddress);
        //发件人
        email.setFrom("Bison·Song");
        try {
            javaMailSender.send(email);
            LOG.info("验证码邮件已经发送");
        } catch (MailException e) {
            LOG.error("发送验证码邮件时出现异常！", e);
        }
    }
}
