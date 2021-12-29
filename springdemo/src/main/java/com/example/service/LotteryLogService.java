package com.example.service;

import com.example.entity.LotteryLog;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: LotteryLogService</p>
 * <p>Description: 抽奖日志(LotteryLog)表服务接口</p>
 * @author songyx
 * @date 2021/12/28
 */
public interface LotteryLogService {

    /**
     * <p>Title: queryById</p>
     * <p>Description: 通过ID查询单条数据</p>
     * @param id 主键
     * @return com.example.entity.LotteryLog
     */
    LotteryLog queryById(String id);

    /**
     * <p>Title: queryAllByLimit</p>
     * <p>Description: 查询指定行数据</p>
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param lotteryUserId 抽奖人编号
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String, Object> queryAllByLimit(int offset, int limit, String lotteryUserId);

    /**
     * <p>Title: queryAll</p>
     * <p>Description: 通过实体作为筛选条件查询</p>
     * @param lotteryLog 实例对象
     * @return java.util.List<com.example.entity.LotteryLog>
     */
    List<LotteryLog> queryAll(LotteryLog lotteryLog);

    /**
     * <p>Title: insert</p>
     * <p>Description: 新增数据</p>
     * @param lotteryLog 实例对象
     */
    void insert(LotteryLog lotteryLog);

    /**
     * <p>Title: deleteById</p>
     * <p>Description: 通过主键删除数据</p>
     * @param id 主键
     */
    void deleteById(String id);
}
