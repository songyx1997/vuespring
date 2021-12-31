package com.example.dao;

import com.example.entity.StandUpItemRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Title: StandUpItemRecordDao</p>
 * <p>Description: 站会项目记录表(StandUpItemRecord)表数据库访问层</p>
 * @author songyx
 * @date 2021/12/31
 */
public interface StandUpItemRecordDao {

    /**
     * <p>Title: queryById</p>
     * <p>Description: 通过ID查询单条数据</p>
     * @param id 主键
     * @return com.example.entity.StandUpItemRecord
     */
    StandUpItemRecord queryById(String id);

    /**
     * <p>Title: queryAllByLimit</p>
     * <p>Description: 查询指定行数据</p>
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return java.util.List<com.example.entity.StandUpItemRecord>
     */
    List<StandUpItemRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * <p>Title: queryAll</p>
     * <p>Description: 通过实体作为筛选条件查询</p>
     * @param standUpItemRecord 实例对象
     * @return java.util.List<com.example.entity.StandUpItemRecord>
     */
    List<StandUpItemRecord> queryAll(StandUpItemRecord standUpItemRecord);

    /**
     * <p>Title: insert</p>
     * <p>Description: 新增数据</p>
     * @param standUpItemRecord 实例对象
     * @return int
     */
    int insert(StandUpItemRecord standUpItemRecord);

    /**
     * <p>Title: update</p>
     * <p>Description: 修改数据</p>
     * @param standUpItemRecord 实例对象
     * @return int
     */
    int update(StandUpItemRecord standUpItemRecord);

    /**
     * <p>Title: deleteById</p>
     * <p>Description: 通过主键删除数据</p>
     * @param id 主键
     * @return int
     */
    int deleteById(String id);
}
