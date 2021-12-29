package com.example.service.impl;

import com.example.dao.GroupDao;
import com.example.entity.Group;
import com.example.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title: GroupServiceImpl</p>
 * <p>Description: 小组表(Group)表服务实现类</p>
 * @author songyx
 * @date 2021/12/24
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupDao groupDao;

    @Override
    public Group queryById(String groupId) {
        return groupDao.queryById(groupId);
    }

    @Override
    public List<Group> queryAll(Group group) {
        return groupDao.queryAll(group);
    }

    @Override
    public Group insert(Group group) {
        groupDao.insert(group);
        return group;
    }

    @Override
    public Group update(Group group) {
        groupDao.update(group);
        return queryById(group.getGroupId());
    }
}
