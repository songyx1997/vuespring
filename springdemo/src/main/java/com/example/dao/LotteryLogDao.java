package com.example.dao;

import com.example.entity.LotteryLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Title: LotteryLogDao</p>
 * <p>Description: 抽奖日志(LotteryLog)表数据库访问层</p>
 * @author songyx
 * @date 2021/12/28
 */
public interface LotteryLogDao {

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
     * @return java.util.List<com.example.entity.LotteryLog>
     */
    List<LotteryLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * <p>Title: queryTotalNum</p>
     * <p>Description: 查询日志总数</p>
     * @return int
     */
    int queryTotalNum();

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
     * @return int
     */
    int insert(LotteryLog lotteryLog);

    /**
     * <p>Title: deleteById</p>
     * <p>Description: 通过主键删除数据</p>
     * @param id 主键
     * @return int
     */
    int deleteById(String id);
}
