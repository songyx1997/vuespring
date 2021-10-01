package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
