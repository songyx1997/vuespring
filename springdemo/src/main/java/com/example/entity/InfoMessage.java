package com.example.entity;

/**
 * <p>Title: InfoMessage</p>
 * <p>Description: 返回信息类</p>
 * @author songy
 * @date 2021/9/24
 */
public class InfoMessage {
    private String returnCode;
    private String returnMessage;

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

}
