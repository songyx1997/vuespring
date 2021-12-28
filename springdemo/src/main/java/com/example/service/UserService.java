package com.example.service;

import com.example.entity.User;

import java.util.List;

/**
 * <p>Title: UserService</p>
 * <p>Description: 用户表(User)表服务接口</p>
 * @author songy
 * @date 2021/9/24
 */
public interface UserService {

    /**
     * <p>Title: queryById</p>
     * <p>Description: 查询单个</p>
     * @param userId 用户编号
     * @return com.example.entity.User
     */
    User queryById(String userId);

    /**
     * <p>Title: queryAll</p>
     * <p>Description: 通过实体作为筛选条件查询</p>
     * @param user 实例对象
     * @return java.util.List<com.example.entity.User>
     */
    List<User> queryAll(User user);

    /**
     * <p>Title: init</p>
     * <p>Description: 初始化注册</p>
     * @param user 实例对象
     */
    void init(User user);

    /**
     * <p>Title: updateAllByKey</p>
     * <p>Description: 通过主要信息修改数据</p>
     * @param user 实例对象
     */
    void updateAllByKey(User user);
    
    /**
     * <p>Title: selectUserInfoByUserId</p>
     * <p>Description: 通过用户编号查询用户信息</p>
     * @param userId 用户编号
     * @return com.example.entity.User
     */
    User selectUserInfoByUserId(String userId);

    /**
     * <p>Title: getUserNamesByUserId</p>
     * <p>Description: 通过用户编号查询全部小组成员名</p>
     * @param userId 用户编号
     * @return java.util.List<java.lang.String>
     */
    List<String> getUserNamesByUserId(String userId);
}
