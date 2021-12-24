package com.example.controller;

import com.example.entity.Group;
import com.example.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title: GroupController</p>
 * <p>Description: 小组表(Group)表控制层</p>
 * @author songyx
 * @date 2021/12/24
 */
@RestController
@RequestMapping("/api/group")
public class GroupController {

    private static final Logger LOG = LoggerFactory.getLogger(GroupController.class);

    @Resource
    private GroupService groupService;

    /**
     * <p>Title: getAllGroups</p>
     * <p>Description: 查询所有项目组</p>
     * @return java.util.List<com.example.entity.Group>
     */
    @CrossOrigin
    @GetMapping("/getAllGroups")
    public List<Group> getAllGroups() {
        LOG.info("开始查询所有项目组");
        List<Group> groups = groupService.queryAll(new Group());
        LOG.info("共查询到{}个项目组", groups.size());
        return groups;
    }
}