package com.example.service.impl;

import com.example.dao.StandUpItemRecordDao;
import com.example.entity.InfoMessage;
import com.example.service.StandUpItemRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
