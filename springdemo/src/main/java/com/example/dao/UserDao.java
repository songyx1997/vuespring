package com.example.dao;

import com.example.entity.User;
import java.util.List;

/**
 * <p>Title: UserDao</p>
 * <p>Description: 用户表(User)表数据库访问层</p>
 * @author songy
 * @date 2021/9/24
 */
public interface UserDao {

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
}
