package com.example.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: InfoMessage</p>
 * <p>Description: 返回信息类</p>
 * @author songy
 * @date 2021/9/24
 */
public class InfoMessage {
    /**
     * 返回码：成功
     */
    public static final String SUCCESS = "SUCCESS";
    /**
     * 返回码：失败
     */
    public static final String FAIL = "FAIL";
    /**
     * 返回码：未知
     */
    public static final String UNKNOWN = "UNKNOWN";
    /**
     * 返回码
     */
    private String returnCode;
    /**
     * 返回信息
     */
    private String returnMessage;
    /**
     * 返回数据
     */
    Map<String, Object> paraMap = new HashMap<>();

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Map<String, Object> getParaMap() {
        return paraMap;
    }

    public void setParaMap(Map<String, Object> paraMap) {
        this.paraMap = paraMap;
    }
}
