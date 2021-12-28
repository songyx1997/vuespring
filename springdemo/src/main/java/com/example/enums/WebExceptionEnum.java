package com.example.enums;

/**
 * <p>Title: WebExceptionEnum</p>
 * <p>Description: 页面异常枚举类</p>
 * @author songy
 * @date 2021/10/7
 */
public enum WebExceptionEnum {
    /**
     * 通用异常
     */
    WEB_DEMO_000000("000000", "%s"),
    /**
     * 新增数据异常
     */
    WEB_DEMO_000001("000001", "新增%s数据出现异常"),
    /**
     * 更新数据异常
     */
    WEB_DEMO_000002("000002", "更新%s数据出现异常"),
    /**
     * 删除数据异常
     */
    WEB_DEMO_000003("000003", "删除%s数据出现异常");

    private String code;

    private String message;

    WebExceptionEnum(String errorCode, String errorMsg) {
        this.code = errorCode;
        this.message = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
