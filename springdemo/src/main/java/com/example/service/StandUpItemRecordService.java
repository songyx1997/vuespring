package com.example.service;

import com.example.entity.StandUpItemRecord;

import java.util.Map;

/**
 * <p>Title: StandUpItemRecordService</p>
 * <p>Description: 站会项目记录表(StandUpItemRecord)表服务接口</p>
 * @author songyx
 * @date 2021/12/31
 */
public interface StandUpItemRecordService {

    /**
     * <p>Title: insert</p>
     * <p>Description: 新增数据</p>
     * @param standUpItemRecord 实例对象
     */
    void insert(StandUpItemRecord standUpItemRecord);

    /**
     * <p>Title: queryAllByLimit</p>
     * <p>Description: 查询指定行数据</p>
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param currentUserGroupId 当前用户小组编号
     * @param itemStyle 项目类型(0-风险项、1-跟进项、2-待改进项)
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String, Object> queryAllByLimit(int offset, int limit, String currentUserGroupId, String itemStyle);
}
