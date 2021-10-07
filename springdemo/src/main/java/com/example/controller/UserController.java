package com.example.controller;

import com.example.entity.InfoMessage;
import com.example.entity.User;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.MailService;
import com.example.service.UserService;
import com.example.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: LoginController</p>
 * <p>Description: 登录控制类</p>
 * @author songy
 * @date 2021/9/24
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private static final int RESEND_THRESHOLD = 1;

    @Resource
    private UserService userService;
    @Resource
    private MailService mailService;

    /**
     * <p>Title: login</p>
     * <p>Description: 登录测试</p>
     * @param requestUser 登录用户
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public InfoMessage login(@RequestBody User requestUser) {
        InfoMessage infoMessage = new InfoMessage();
        String userName = requestUser.getUserName();
        LOG.info("登录账户名为：{}", userName);
        List<User> users = userService.queryAll(requestUser);
        if (users.isEmpty()) {
            infoMessage.setReturnCode("400");
            infoMessage.setReturnMessage("账号不存在或密码错误");
        } else {
            infoMessage.setReturnCode("200");
            infoMessage.setReturnMessage("登录成功");
        }
        return infoMessage;
    }

    /**
     * <p>Title: sendMailCode</p>
     * <p>Description: 发送邮件验证码</p>
     * @param registerUser 注册用户
     */
    @CrossOrigin
    @PostMapping(value = "/sendMailCode")
    @ResponseBody
    public InfoMessage sendMailCode(@RequestBody User registerUser) {
        InfoMessage infoMessage = new InfoMessage();
        String userEmail = registerUser.getUserEmail();
        LOG.info("注册邮箱为：{}", userEmail);
        List<User> users = userService.queryAll(registerUser);
        try {
            if (users.isEmpty()) {
                LOG.info("首次注册发送邮件，初始化入库");
                registerUser.setNewestMailCode(mailService.sendMailCode(userEmail));
                userService.init(registerUser);
            } else if (!StringUtils.isBlank(users.get(0).getUserPassword())) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "该邮箱已被注册！");
            } else if (DateUtil.getDiffMinutes(users.get(0).getCreationTime(), new Date()) < RESEND_THRESHOLD) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "邮件验证码仍未过期！");
            } else {
                LOG.info("非首次注册发送邮件，更新入库");
                registerUser.setNewestMailCode(mailService.sendMailCode(userEmail));
                userService.updateAllByUserEmail(registerUser);
            }
        } catch (WebException e) {
            LOG.error("注册数据入库时出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("发送成功！");
        return infoMessage;
    }
}
