package com.wuxin.exception;

/**
 * @author: wuxin001
 * @date: 2022/7/17 11:07
 * @Description:
 */
public class CustomException extends RuntimeException {
    private int code;

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(String message) {
        super(message);
        this.code = 402;
    }
}
