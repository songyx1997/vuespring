package com.example.exception;

import com.example.enums.WebExceptionEnum;

/**
 * <p>Title: WebException</p>
 * <p>Description: 页面异常类</p>
 * @author songy
 * @date 2021/10/7
 */
public class WebException extends RuntimeException {

    private String errorCode;

    private String errorMessage;

    public WebException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public WebException(WebExceptionEnum webExceptionEnum, String... message) {
        super(String.format(webExceptionEnum.getMessage(), message));
        this.errorCode = webExceptionEnum.getCode();
        this.errorMessage = String.format(webExceptionEnum.getMessage(), message);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
