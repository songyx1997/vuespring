package com.example.enums;

/**
 * <p>Title: NumberEnum</p>
 * <p>Description: 数字枚举</p>
 * @author songy
 * @date 2021/12/20
 */
public enum NumberEnum {
    /**
     * 用户表-用户角色(0-admin)
     */
    USER_USER_ROLE_0("0", "admin"),
    /**
     * 用户表-用户角色(1-general)
     */
    USER_USER_ROLE_1("1", "general"),
    /**
     * 抽奖日志表-抽奖方式(0-turntable)
     */
    LOTTERY_LOG_LOTTERY_STYLE_0("0", "turntable"),
    /**
     * 站会项目记录表-项目类型(0-风险项)
     */
    STAND_UP_ITEM_RECORD_ITEM_STYLE_0("0", "风险项"),
    /**
     * 站会项目记录表-项目类型(1-待改进项)
     */
    STAND_UP_ITEM_RECORD_ITEM_STYLE_1("1", "待改进项"),
    /**
     * 站会项目记录表-项目类型(2-跟进项)
     */
    STAND_UP_ITEM_RECORD_ITEM_STYLE_2("2", "跟进项"),
    /**
     * 站会项目记录表-状态(0-待处理)
     */
    STAND_UP_ITEM_RECORD_STATE_0("0", "待处理"),
    /**
     * 站会项目记录表-状态(1-活动中)
     */
    STAND_UP_ITEM_RECORD_STATE_1("1", "活动中"),
    /**
     * 站会项目记录表-状态(2-已关闭)
     */
    STAND_UP_ITEM_RECORD_STATE_2("2", "已关闭"),
    /**
     * 站会项目记录表-优先级(0-低)
     */
    STAND_UP_ITEM_RECORD_PRIORITY_0("0", "低"),
    /**
     * 站会项目记录表-优先级(1-中)
     */
    STAND_UP_ITEM_RECORD_PRIORITY_1("1", "中"),
    /**
     * 站会项目记录表-优先级(2-高)
     */
    STAND_UP_ITEM_RECORD_PRIORITY_2("2", "高");

    private String number;

    private String content;

    NumberEnum(String number, String content) {
        this.number = number;
        this.content = content;
    }

    public String getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }
}
