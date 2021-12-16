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
     * <p>Title: randomNumberOfSix</p>
     * <p>Description: 生成6位随机数</p>
     * @return java.lang.String
     */
    public static String randomNumberOfSix() {
        return RandomStringUtils.random(6, "0123456789".toCharArray());
    }
}
