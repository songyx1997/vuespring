package com.example.service.impl;

import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.MailService;
import com.example.utils.RandomStringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:application.yml")
public class MailServiceImpl implements MailService {

    private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);

    @Value("${spring.mail.username}")
    private String fromEmailAddress;

    @Resource
    private JavaMailSender javaMailSender;

    @Async
    @Override
    public String sendMailCode(String sendEmailAddress) {
        SimpleMailMessage email = new SimpleMailMessage();
        //邮件标题
        email.setSubject("注册验证码");
        String mailCode = RandomStringUtil.randomMailCode();
        LOG.info("生成6位数字验证码:{}", mailCode);
        //邮件正文
        String emailText = "尊敬的用户，您好:" + StringUtils.LF + StringUtils.LF + "本次请求的邮件验证码为：" +
                mailCode + "，本验证码1分钟内有效，请及时输入（请勿泄露此验证码）。" + StringUtils.LF +
                StringUtils.LF + "如非本人操作，请忽略该邮件。" + StringUtils.LF + "(这是一封自动发送的邮件，请不要直接回复）";
        email.setText(emailText);
        //收件人邮箱地址
        email.setTo(sendEmailAddress);
        //发件人邮箱地址
        email.setFrom(fromEmailAddress);
        LOG.info("开始发送验证码邮件");
        try {
            javaMailSender.send(email);
        } catch (MailException e) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "发送失败，请确认邮箱号！");
        }
        LOG.info("验证码邮件发送成功！");
        return mailCode;
    }
}
