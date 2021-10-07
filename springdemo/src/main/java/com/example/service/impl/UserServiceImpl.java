package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.UserService;
import com.example.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: 用户表(User)表服务实现类</p>
 * @author songy
 * @date 2021/9/24
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User queryById() {
        return userDao.queryById();
    }

    @Override
    public List<User> queryAll(User user) {
        return userDao.queryAll(user);
    }

    @Override
    public void init(User user) {
        user.setId(DateUtil.getCurrentTimeStr(DateUtil.FULL_PRIMARY_KEY_TIME));
        user.setUserName(user.getUserEmail());
        user.setCreationTime(new Date());
        int updateNum = userDao.insert(user);
        if (updateNum != 1) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000001, "用户表");
        }
    }

    @Override
    public void updateAllByUserEmail(User user) {
        user.setCreationTime(new Date());
        int updateNum = userDao.updateAllByUserEmail(user);
        if (updateNum != 1) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000002, "用户表");
        }
    }
}
