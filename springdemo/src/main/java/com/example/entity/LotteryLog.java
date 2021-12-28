package com.example.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>Title: LotteryLog</p>
 * <p>Description: 抽奖日志类</p>
 * @author songy
 * @date 2021/12/14
 */
public class LotteryLog implements Serializable {
    /**
    * 无意义主键
    */
    private String id;
    /**
    * 抽奖方式(0-turntable)
    */
    private String lotteryStyle;
    /**
    * 抽奖人编号
    */
    private String lotteryUserId;
    /**
     * 抽奖人用户名
     */
    private String lotteryUserName;
    /**
    * 中奖人编号
    */
    private String winnerUserId;
    /**
     * 中奖人用户名
     */
    private String winnerUserName;
    /**
    * 备用字段
    */
    private String ext1;
    /**
    * 备用字段
    */
    private String ext2;
    /**
    * 备用字段
    */
    private String ext3;
    /**
    * 创建时间
    */
    private Date creationTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLotteryStyle() {
        return lotteryStyle;
    }

    public void setLotteryStyle(String lotteryStyle) {
        this.lotteryStyle = lotteryStyle;
    }

    public String getLotteryUserId() {
        return lotteryUserId;
    }

    public void setLotteryUserId(String lotteryUserId) {
        this.lotteryUserId = lotteryUserId;
    }

    public String getWinnerUserId() {
        return winnerUserId;
    }

    public void setWinnerUserId(String winnerUserId) {
        this.winnerUserId = winnerUserId;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getLotteryUserName() {
        return lotteryUserName;
    }

    public void setLotteryUserName(String lotteryUserName) {
        this.lotteryUserName = lotteryUserName;
    }

    public String getWinnerUserName() {
        return winnerUserName;
    }

    public void setWinnerUserName(String winnerUserName) {
        this.winnerUserName = winnerUserName;
    }
}
