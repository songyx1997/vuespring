package com.example.controller;

import com.example.entity.InfoMessage;
import com.example.entity.StandUpItemRecord;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.StandUpItemRecordService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

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

    /**
     * <p>Title: add</p>
     * <p>Description: 新增项目记录</p>
     * @param standUpItemRecord 记录内容
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/add")
    public InfoMessage add(@RequestBody StandUpItemRecord standUpItemRecord) {
        LOG.info("新增项目记录");
        try {
            if (StringUtils.isBlank(standUpItemRecord.getCurrentUserGroupId())) {
                throw new WebException(WebExceptionEnum.WEB_DEMO_000000, "当前用户未设置项目组！");
            }
            preprocessingParam(standUpItemRecord);
            standUpItemRecordService.insert(standUpItemRecord);
        } catch (WebException e) {
            LOG.error("新增项目记录出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("新增记录成功！");
        return infoMessage;
    }

    /**
     * <p>Title: edit</p>
     * <p>Description: 修改项目记录</p>
     * @param standUpItemRecord 记录内容
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/edit")
    public InfoMessage edit(@RequestBody StandUpItemRecord standUpItemRecord) {
        LOG.info("修改项目记录");
        try {
            preprocessingParam(standUpItemRecord);
            standUpItemRecordService.update(standUpItemRecord);
        } catch (WebException e) {
            LOG.error("修改项目记录出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("修改记录成功！");
        return infoMessage;
    }

    /**
     * <p>Title: search</p>
     * <p>Description: 查询</p>
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param currentUserGroupId 当前用户小组编号
     * @param itemStyle 项目类型(0-风险项、1-跟进项、2-待改进项)
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @CrossOrigin
    @GetMapping(value = "/search")
    public Map<String, Object> search(@RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                      @RequestParam("currentUserGroupId") String currentUserGroupId, @RequestParam("itemStyle") String itemStyle) {
        LOG.info("查询项目记录，查询起始位置={}，查询条数={}，项目类型(0-风险项、1-跟进项、2-待改进项)={}", offset, limit, itemStyle);
        return standUpItemRecordService.queryAllByLimit(offset, limit, currentUserGroupId, itemStyle);
    }

    /**
     * <p>Title: delete</p>
     * <p>Description: 删除</p>
     * @param id 无意义主键
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @GetMapping(value = "/delete")
    public InfoMessage delete(@RequestParam("id") String id) {
        LOG.info("待删除项目记录主键为{}", id);
        try {
            standUpItemRecordService.deleteById(id);
        } catch (WebException e) {
            LOG.error("删除项目记录出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("删除记录成功！");
        return infoMessage;
    }

    private void preprocessingParam(StandUpItemRecord standUpItemRecord) {
        standUpItemRecord.setItemDescription(StringUtils.isBlank(standUpItemRecord.getItemDescription()) ?
                StringUtils.EMPTY : standUpItemRecord.getItemDescription().trim());
        standUpItemRecord.setMeasure(StringUtils.isBlank(standUpItemRecord.getMeasure()) ?
                StringUtils.EMPTY : standUpItemRecord.getMeasure().trim());
        standUpItemRecord.setRemark(StringUtils.isBlank(standUpItemRecord.getRemark()) ?
                StringUtils.EMPTY : standUpItemRecord.getRemark());
    }
}
