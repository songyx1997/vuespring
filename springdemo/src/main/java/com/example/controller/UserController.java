package com.example.controller;

import com.example.entity.InfoMessage;
import com.example.entity.User;
import com.example.service.MailService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
     * @param requestUser 注册用户
     */
    @CrossOrigin
    @PostMapping(value = "/sendMailCode")
    @ResponseBody
    public void sendMailCode(@RequestBody User requestUser) {
        String userEmail = requestUser.getUserEmail();
        LOG.info("注册邮箱为：{}", userEmail);
        mailService.sendMailCode(userEmail);
    }
}
