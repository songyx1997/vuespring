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

    private static final int RESEND_THRESHOLD = 1;

    @Resource
    private UserService userService;
    @Resource
    private MailService mailService;

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
     * <p>Title: sendMailCode</p>
     * <p>Description: 发送邮件验证码</p>
     * @param registerUser 注册用户
     */
    @CrossOrigin
    @PostMapping(value = "/sendMailCode")
    @ResponseBody
    public InfoMessage sendMailCode(@RequestBody User registerUser) {
        String userEmail = registerUser.getUserEmail();
        LOG.info("注册邮箱为：{}", userEmail);
        List<User> users = userService.queryAll(registerUser);
        try {
            if (users.isEmpty()) {
                LOG.info("首次注册发送邮件，初始化入库");
                registerUser.setLastCode(mailService.sendMailCode(userEmail));
                userService.init(registerUser);
            } else if (!StringUtils.isBlank(users.get(0).getUserPassword())) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "该邮箱已被注册！");
            } else if (DateUtil.getDiffMinutes(users.get(0).getCreationTime(), new Date()) < RESEND_THRESHOLD) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "邮件验证码仍未过期！");
            } else {
                LOG.info("非首次注册发送邮件，更新入库");
                registerUser.setLastCode(mailService.sendMailCode(userEmail));
                registerUser.setCreationTime(new Date());
                userService.updateAllByKey(registerUser);
            }
        } catch (WebException e) {
            LOG.error("发送邮件验证码出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("发送成功！");
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
        String mailCode = registerUser.getLastCode();
        LOG.info("注册邮箱为：{}，输入邮箱验证码为：{}", userEmail, mailCode);
        User anoUser = new User();
        anoUser.setUserEmail(userEmail);
        List<User> users = userService.queryAll(anoUser);
        try {
            if (users.isEmpty()) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "未发送邮箱验证码！");
            } else if (!StringUtils.isBlank(users.get(0).getUserPassword())) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "该邮箱已被注册！");
            } else if (DateUtil.getDiffMinutes(users.get(0).getCreationTime(), new Date()) >= RESEND_THRESHOLD) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "邮件验证码已过期！");
            } else if (!StringUtils.equals(users.get(0).getLastCode(), mailCode)) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "邮件验证码不正确！");
            } else {
                LOG.info("更新密码、创建时间、登陆时间");
                registerUser.setUserId(users.get(0).getUserId());
                Date currentTime = new Date();
                registerUser.setCreationTime(currentTime);
                registerUser.setLastLoginTime(currentTime);
                userService.updateAllByKey(registerUser);
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
