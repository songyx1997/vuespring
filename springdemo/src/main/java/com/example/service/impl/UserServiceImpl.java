package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.enums.NumberEnum;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.UserService;
import com.example.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public User queryById(String userId) {
        return userDao.queryById(userId);
    }

    @Override
    public List<User> queryAll(User user) {
        return userDao.queryAll(user);
    }

    @Override
    public void init(User user) {
        user.setUserId(DateUtil.getCurrentTimeStr(DateUtil.FULL_PRIMARY_KEY_TIME));
        user.setUserName(user.getUserEmail());
        user.setUserRole(NumberEnum.USER_USER_ROLE_1.getNumber());
        user.setGroupId(StringUtils.EMPTY);
        user.setUserPhone(StringUtils.EMPTY);
        String currentTime = DateUtil.getCurrentTimeStr(DateUtil.FULL_STANDARD_TIME);
        user.setCreationTime(currentTime);
        user.setLastLoginTime(currentTime);
        user.setUpdateTime(currentTime);
        int updateNum = userDao.insert(user);
        if (updateNum != 1) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000001, "用户表");
        }
    }

    @Override
    public void updateAllByKey(User user) {
        LOG.info("更新修改时间");
        user.setUpdateTime(DateUtil.getCurrentTimeStr(DateUtil.FULL_STANDARD_TIME));
        int updateNum = userDao.updateAllByKey(user);
        if (updateNum != 1) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000002, "用户表");
        }
    }

    @Override
    public User selectUserInfoByUserId(String userId) {
        return userDao.selectUserInfoByUserId(userId);
    }

    @Override
    public List<User> getUserNamesByUserId(String userId) {
        User currentUser = userDao.queryById(userId);
        String groupId = currentUser.getGroupId();
        if (StringUtils.isNotBlank(groupId)) {
            LOG.info("当前用户小组编号为{}", groupId);
            return userDao.getUserNamesByGroupId(groupId);
        } else {
            LOG.info("通过用户编号查询全部小组成员名，当前用户小组编号为空");
            return null;
        }
    }
}
