package com.example.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * <p>Title: DateUtil</p>
 * <p>Description: 时间工具类</p>
 * @author songy
 * @date 2021/10/7
 */
public class DateUtil {

    public static final String FULL_STANDARD_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String FULL_PRIMARY_KEY_TIME = "yyyyMMddHHmmssSSS";

    public static final String FULL_STANDARD_DATE = "yyyy-MM-dd";

    /**
     * <p>Title: getCurrentTimeStr</p>
     * <p>Description: 当前时间字符串</p>
     * @param pattern 格式
     * @return java.lang.String
     */
    public static String getCurrentTimeStr(String pattern) {
        Date currentTime = new Date();
        return DateFormatUtils.format(currentTime, pattern);
    }

    /**
     * <p>Title: getCurrentDateStr</p>
     * <p>Description: 当前日期字符串</p>
     * @param pattern 格式
     * @return java.lang.String
     */
    public static String getCurrentDateStr(String pattern) {
        Date currentDate = new Date();
        return DateFormatUtils.format(currentDate, pattern);
    }

    /**
     * <p>Title: getDiffMillisecond</p>
     * <p>Description: 计算日期相差的毫秒数</p>
     * @param date1 日期一
     * @param date2 日期二
     * @return long
     */
    public static long getDiffMillisecond(Date date1, Date date2) {
        return date1.getTime() > date2.getTime() ? date1.getTime() - date2.getTime() : date2.getTime() - date1.getTime();
    }

    /**
     * <p>Title: getDiffMinutes</p>
     * <p>Description: 计算日期相差的分钟数</p>
     * @param date1 日期一
     * @param date2 日期二
     * @return int
     */
    public static long getDiffMinutes(Date date1, Date date2) {
        return getDiffMillisecond(date1, date2) / 60000;
    }
}
