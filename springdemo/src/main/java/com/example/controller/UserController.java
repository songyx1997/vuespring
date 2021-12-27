package com.example.controller;

import com.example.entity.InfoMessage;
import com.example.entity.User;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/login")
    public InfoMessage login(@RequestBody User loginUser) {
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
                User user = users.isEmpty() ? anoUsers.get(0) : users.get(0);
                user.setLastLoginTime(new Date());
                userService.updateAllByKey(user);
                LOG.info("返回登陆用户信息");
                user.setUserPassword(null);
                Map<String, Object> paraMap = new HashMap<>(1);
                paraMap.put("user", user);
                infoMessage.setParaMap(paraMap);
            }
        } catch (WebException e) {
            LOG.error("登陆时出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
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
        Map<String, Object> paraMap = new HashMap<>(1);
        LOG.info("返回注册用户信息");
        registerUser.setUserPassword(null);
        paraMap.put("user", registerUser);
        infoMessage.setParaMap(paraMap);
        return infoMessage;
    }

    /**
     * <p>Title: editPassword</p>
     * <p>Description: 修改密码</p>
     * @param user 待修改用户
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/editPassword")
    public InfoMessage editPassword(@RequestBody User user) {
        User oldUser = userService.queryById(user.getUserId());
        try {
            if (!StringUtils.equals(oldUser.getUserPassword(), user.getUserPassword())) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "旧密码不正确！");
            } else {
                LOG.info("更新密码");
                oldUser.setUserPassword(user.getExt1());
                userService.updateAllByKey(oldUser);
            }
        } catch (WebException e) {
            LOG.error("修改密码时出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("修改密码成功！");
        return infoMessage;
    }

    /**
     * <p>Title: selectUserInfo</p>
     * <p>Description: 查询用户信息</p>
     * @param user 用户(用户编号)
     * @return com.example.entity.User
     */
    @CrossOrigin
    @PostMapping(value = "/selectUserInfo")
    public User selectUserInfo(@RequestBody User user) {
        LOG.info("查询用户信息，用户编号为{}", user.getUserId());
        return userService.selectUserInfoByUserId(user.getUserId());
    }

    /**
     * <p>Title: editUserInfo</p>
     * <p>Description: 更新个人信息</p>
     * @param user 待修改用户
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/editUserInfo")
    public InfoMessage editUserInfo(@RequestBody User user) {
        String phone = StringUtils.isEmpty(user.getUserPhone()) ? user.getUserPhone() : user.getUserPhone().trim();
        LOG.info("更新个人信息，用户编号为{}，用户名为{}，小组编号为{}，手机号为{}，邮箱为{}", user.getUserId(), user.getUserName(),
                user.getGroupId(), phone, user.getUserEmail());
        try {
            userService.updateAllByKey(user);
            LOG.info("返回更新后的用户信息");
            User newUser = userService.selectUserInfoByUserId(user.getUserId());
            Map<String, Object> paraMap = new HashMap<>(1);
            paraMap.put("user", newUser);
            infoMessage.setParaMap(paraMap);
        } catch (WebException e) {
            LOG.error("更新个人信息时出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("修改个人信息成功！");
        return infoMessage;
    }
}
