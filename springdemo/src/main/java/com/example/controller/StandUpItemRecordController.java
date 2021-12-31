package com.example.controller;

import com.example.entity.InfoMessage;
import com.example.service.StandUpItemRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Title: StandUpItemRecordController</p>
 * <p>Description: 站会项目记录表(StandUpItemRecord)表控制层</p>
 * @author songyx
 * @date 2021/12/31
 */
@RestController
@RequestMapping("/api/standUpItemRecord")
public class StandUpItemRecordController {

    private static final Logger LOG = LoggerFactory.getLogger(StandUpItemRecordController.class);
    private final InfoMessage infoMessage = new InfoMessage();

    @Resource
    private StandUpItemRecordService standUpItemRecordService;

}
