package com.example.service.impl;

import com.example.dao.StandUpItemRecordDao;
import com.example.entity.InfoMessage;
import com.example.entity.StandUpItemRecord;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.StandUpItemRecordService;
import com.example.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: StandUpItemRecordServiceImpl</p>
 * <p>Description: 站会项目记录表(StandUpItemRecord)表服务实现类</p>
 * @author songyx
 * @date 2021/12/31
 */
@Service("standUpItemRecordService")
public class StandUpItemRecordServiceImpl implements StandUpItemRecordService {

    private static final Logger LOG = LoggerFactory.getLogger(StandUpItemRecordServiceImpl.class);
    private final InfoMessage infoMessage = new InfoMessage();

    @Resource
    private StandUpItemRecordDao standUpItemRecordDao;

    @Override
    public void insert(StandUpItemRecord standUpItemRecord) {
        LOG.info("初始化主键、创建时间、更新时间");
        standUpItemRecord.setId(DateUtil.getCurrentTimeStr(DateUtil.FULL_PRIMARY_KEY_TIME));
        standUpItemRecord.setCreationTime(DateUtil.getCurrentTimeStr(DateUtil.FULL_STANDARD_TIME));
        standUpItemRecord.setUpdateTime(DateUtil.getCurrentTimeStr(DateUtil.FULL_STANDARD_TIME));
        int updateNum = standUpItemRecordDao.insert(standUpItemRecord);
        if (updateNum != 1) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000001, "站会项目记录表");
        }
    }

    @Override
    public Map<String, Object> queryAllByLimit(int offset, int limit, String currentUserGroupId, String itemStyle) {
        Map<String, Object> resultMap = new HashMap<>(2);
        if (StringUtils.isBlank(currentUserGroupId)) {
            resultMap.put("total", 0);
            resultMap.put("list", null);
            return resultMap;
        }
        List<StandUpItemRecord> list = standUpItemRecordDao.queryAllByLimit(offset, limit, currentUserGroupId, itemStyle);
        LOG.info("共查询到{}条站会项目记录", list.size());
        int total = standUpItemRecordDao.queryTotalNum(currentUserGroupId, itemStyle);
        LOG.info("总共有{}条记录", total);
        resultMap.put("total", total);
        resultMap.put("list", list);
        return resultMap;
    }
}
