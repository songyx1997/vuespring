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
     * <p>Description: 新增所有列</p>
     * @param user 实例对象
     * @return int
     */
    int insert(User user);

    /**
     * <p>Title: updateAllByKey</p>
     * <p>Description: 通过主要信息修改数据</p>
     * @param user 实例对象
     * @return int
     */
    int updateAllByKey(User user);

    /**
     * <p>Title: selectUserInfoByUserId</p>
     * <p>Description: 通过用户编号查询用户信息</p>
     * @param userId 用户编号
     * @return com.example.entity.User
     */
    User selectUserInfoByUserId(String userId);

    /**
     * <p>Title: getUserNamesByGroupId</p>
     * <p>Description: 通过小组编号查询全部小组成员名</p>
     * @param groupId 小组编号
     * @return java.util.List<java.lang.String>
     */
    List<String> getUserNamesByGroupId(String groupId);
}
