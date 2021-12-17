package com.example.controller;

import com.example.entity.InfoMessage;
import com.example.entity.User;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final InfoMessage infoMessage = new InfoMessage();

    @Resource
    private UserService userService;

    /**
     * <p>Title: login</p>
     * <p>Description: 登录</p>
     * @param loginUser 登录用户
     * @param session 记录登录信息
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public InfoMessage login(@RequestBody User loginUser, HttpSession session) {
        String userName = loginUser.getUserName();
        LOG.info("登录账户名为：{}", userName);
        List<User> users = userService.queryAll(loginUser);
        User anoUser = new User();
        anoUser.setUserEmail(loginUser.getUserName());
        anoUser.setUserPassword(loginUser.getUserPassword());
        List<User> anoUsers = userService.queryAll(anoUser);
        try {
            if (users.isEmpty() && anoUsers.isEmpty()) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "账号不存在或密码错误！");
            } else {
                LOG.info("记录登陆时间，更新入库");
                String userId = users.isEmpty() ? anoUsers.get(0).getUserId() : users.get(0).getUserId();
                loginUser.setUserName(null);
                loginUser.setUserId(userId);
                loginUser.setLastLoginTime(new Date());
                userService.updateAllByKey(loginUser);
            }
        } catch (WebException e) {
            LOG.error("登陆时出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        session.setAttribute("user", loginUser);
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("登录成功！");
        return infoMessage;
    }

    /**
     * <p>Title: register</p>
     * <p>Description: 注册</p>
     * @param registerUser 注册用户
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/register")
    @ResponseBody
    public InfoMessage register(@RequestBody User registerUser) {
        String userEmail = registerUser.getUserEmail();
        LOG.info("注册邮箱为：{}", userEmail);
        User anoUser = new User();
        anoUser.setUserEmail(userEmail);
        List<User> users = userService.queryAll(anoUser);
        try {
            if (!users.isEmpty()) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "该邮箱已被注册！");
            } else {
                LOG.info("初始化注册");
                userService.init(registerUser);
            }
        } catch (WebException e) {
            LOG.error("注册时出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("注册成功！");
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("user", registerUser);
        infoMessage.setParaMap(paraMap);
        return infoMessage;
    }
}
