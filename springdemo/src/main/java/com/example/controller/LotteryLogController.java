package com.example.controller;

import com.example.entity.InfoMessage;
import com.example.entity.LotteryLog;
import com.example.exception.WebException;
import com.example.service.LotteryLogService;
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
 * <p>Title: LotteryLogController</p>
 * <p>Description: 抽奖日志(LotteryLog)表控制层</p>
 * @author songyx
 * @date 2021/12/28
 */
@RestController
@RequestMapping("/api/lotteryLog")
public class LotteryLogController {

    private static final Logger LOG = LoggerFactory.getLogger(LotteryLogController.class);
    private final InfoMessage infoMessage = new InfoMessage();
    
    @Resource
    private LotteryLogService lotteryLogService;

    /**
     * <p>Title: search</p>
     * <p>Description: 查询</p>
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return java.util.List<com.example.entity.LotteryLog>
     */
    @CrossOrigin
    @GetMapping(value = "/search")
    public Map<String, Object> search(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
        LOG.info("查询抽奖结果，查询起始位置{}，查询条数{}", offset, limit);
        return lotteryLogService.queryAllByLimit(offset, limit);
    }
    
    /**
     * <p>Title: add</p>
     * <p>Description: 新增抽奖结果</p>
     * @param lotteryLog 抽奖结果
     * @return com.example.entity.InfoMessage
     */
    @CrossOrigin
    @PostMapping(value = "/add")
    public InfoMessage add(@RequestBody LotteryLog lotteryLog) {
        LOG.info("新增抽奖结果，抽奖人为{}，中奖人为{}", lotteryLog.getLotteryUserName(), lotteryLog.getWinnerUserName());
        try {
            lotteryLogService.insert(lotteryLog);
        } catch (WebException e) {
            LOG.error("新增抽奖结果出现异常！", e);
            infoMessage.setReturnCode(InfoMessage.FAIL);
            infoMessage.setReturnMessage(e.getMessage());
            return infoMessage;
        }
        infoMessage.setReturnCode(InfoMessage.SUCCESS);
        infoMessage.setReturnMessage("新增记录成功！");
        return infoMessage;
    }
}
