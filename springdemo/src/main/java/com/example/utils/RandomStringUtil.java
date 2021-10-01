package com.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * <p>Title: RandomStringUtil</p>
 * <p>Description: 生成随机数工具类</p>
 * @author songy
 * @date 2021/10/2
 */
public class RandomStringUtil {

    /**
     * <p>Title: randomMailCode</p>
     * <p>Description: 生成6位数字验证码</p>
     * @return java.lang.String
     */
    public static String randomMailCode() {
        return RandomStringUtils.random(6, "0123456789".toCharArray());
    }
}
