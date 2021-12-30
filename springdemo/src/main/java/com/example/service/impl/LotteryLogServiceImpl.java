package com.example.service.impl;

import com.example.dao.LotteryLogDao;
import com.example.dao.UserDao;
import com.example.entity.LotteryLog;
import com.example.enums.NumberEnum;
import com.example.enums.WebExceptionEnum;
import com.example.exception.WebException;
import com.example.service.LotteryLogService;
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
 * <p>Title: LotteryLogServiceImpl</p>
 * <p>Description: 抽奖日志(LotteryLog)表服务实现类</p>
 * @author songyx
 * @date 2021/12/28
 */
@Service("lotteryLogService")
public class LotteryLogServiceImpl implements LotteryLogService {

    private static final Logger LOG = LoggerFactory.getLogger(LotteryLogServiceImpl.class);

    @Resource
    private LotteryLogDao lotteryLogDao;
    @Resource
    private UserDao userDao;

    @Override
    public LotteryLog queryById(String id) {
        return lotteryLogDao.queryById(id);
    }

    @Override
    public Map<String, Object> queryAllByLimit(int offset, int limit, String lotteryUserId) {
        String lotteryUserGroupId = userDao.queryById(lotteryUserId).getGroupId();
        LOG.info("抽奖人当前小组编号为{}", lotteryUserGroupId);
        Map<String, Object> resultMap = new HashMap<>(2);
        if (StringUtils.isBlank(lotteryUserGroupId)) {
            resultMap.put("total", 0);
            resultMap.put("list", null);
            return resultMap;
        }
        List<LotteryLog> list = lotteryLogDao.queryAllByLimit(offset, limit, lotteryUserGroupId);
        LOG.info("共查询到{}条抽奖日志", list.size());
        int total = lotteryLogDao.queryTotalNum();
        LOG.info("总共有{}条记录", total);
        resultMap.put("total", total);
        resultMap.put("list", list);
        return resultMap;
    }

    @Override
    public List<LotteryLog> queryAll(LotteryLog lotteryLog) {
        return lotteryLogDao.queryAll(lotteryLog);
    }

    @Override
    public void insert(LotteryLog lotteryLog) {
        lotteryLog.setLotteryStyle(NumberEnum.LOTTERY_LOG_LOTTERY_STYLE_0.getNumber());
        LOG.info("初始化主键、创建时间");
        lotteryLog.setId(DateUtil.getCurrentTimeStr(DateUtil.FULL_PRIMARY_KEY_TIME));
        lotteryLog.setCreationTime(DateUtil.getCurrentTimeStr(DateUtil.FULL_STANDARD_TIME));
        int updateNum = lotteryLogDao.insert(lotteryLog);
        if (updateNum != 1) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000001, "抽奖日志表");
        }
    }

    @Override
    public void deleteById(String id) {
        int deleteNum = lotteryLogDao.deleteById(id);
        if (deleteNum != 1) {
            throw new WebException(WebExceptionEnum.WEB_DEMO_000003, "抽奖日志表");
        }
    }

    @Override
    public Map<String, Integer> getHistogramData(int limit, String lotteryUserId) {
        String lotteryUserGroupId = userDao.queryById(lotteryUserId).getGroupId();
        LOG.info("抽奖人当前小组编号为{}", lotteryUserGroupId);
        Map<String, Integer> resultMap = new HashMap<>(2);
        if (StringUtils.isBlank(lotteryUserGroupId)) {
            return resultMap;
        }
        List<LotteryLog> list = lotteryLogDao.queryAllByLimit(0, limit, lotteryUserGroupId);
        for (LotteryLog lotteryLog : list) {
            String winnerUserName = lotteryLog.getWinnerUserName();
            if (resultMap.get(winnerUserName) == null) {
                int num = 1;
                resultMap.put(winnerUserName, num);
            } else {
                int num = resultMap.get(winnerUserName) + 1;
                resultMap.replace(winnerUserName, num);
            }
        }
        return resultMap;
    }
}
