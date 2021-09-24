package com.example.controller;

import com.example.bean.InfoMessage;
import com.example.bean.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: LoginController</p>
 * <p>Description: 登录控制类</p>
 * @author songy
 * @date 2021/9/24
 */
@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    /**
     * <p>Title: login</p>
     * <p>Description: 登录测试</p>
     * @param requestUser 登录用户
     * @return com.example.bean.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public InfoMessage login(@RequestBody User requestUser) {
        InfoMessage infoMessage = new InfoMessage();
        String userName = requestUser.getUserName();
        if (StringUtils.equals("admin", userName) && StringUtils.equals("123456", requestUser.getPassword())) {
            infoMessage.setReturnMessage("登录成功");
            infoMessage.setReturnCode("200");
        } else {
            infoMessage.setReturnMessage("账号密码错误");
            infoMessage.setReturnCode("400");
        }
        return infoMessage;
    }
}
