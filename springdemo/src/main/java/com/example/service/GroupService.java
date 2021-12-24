package com.example.service;

import com.example.entity.Group;

import java.util.List;

/**
 * <p>Title: GroupService</p>
 * <p>Description: 小组表(Group)表服务接口</p>
 * @author songyx
 * @date 2021/12/24
 */
public interface GroupService {

    /**
     * <p>Title: queryById</p>
     * <p>Description: 通过ID查询单条数据</p>
     * @param groupId 主键
     * @return com.example.entity.Group
     */
    Group queryById(String groupId);

    /**
     * <p>Title: queryAll</p>
     * <p>Description: 通过实体作为筛选条件查询</p>
     * @param group 实例对象
     * @return java.util.List<com.example.entity.Group>
     */
    List<Group> queryAll(Group group);

    /**
     * <p>Title: insert</p>
     * <p>Description: 新增数据</p>
     * @param group 实例对象
     * @return com.example.entity.Group
     */
    Group insert(Group group);

    /**
     * <p>Title: update</p>
     * <p>Description: 修改数据</p>
     * @param group 实例对象
     * @return com.example.entity.Group
     */
    Group update(Group group);
}
