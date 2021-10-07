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
     * @return com.example.entity.User
     */
    User queryById();

    /**
     * <p>Title: queryAll</p>
     * <p>Description: 通过实体作为筛选条件查询</p>
     * @param user 实例对象
     * @return java.util.List<com.example.entity.User>
     */
    List<User> queryAll(User user);

    /**
     * <p>Title: init</p>
     * <p>Description: 初始化（未完成注册）</p>
     * @param user 实例对象
     */
    void init(User user);

    /**
     * <p>Title: updateAllByUserEmail</p>
     * <p>Description: 通过主键修改数据</p>
     * @param user 实例对象
     */
    void updateAllByUserEmail(User user);
}
