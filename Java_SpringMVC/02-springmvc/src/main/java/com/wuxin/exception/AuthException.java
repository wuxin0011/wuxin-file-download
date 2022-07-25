package com.wuxin.exception;

/**
 * @author: wuxin001
 * @date: 2022/7/17 11:12
 * @Description: 未登录异常
 */
public class AuthException extends RuntimeException {
    public AuthException() {
        super();
    }

    public AuthException(String message) {
        super(message);
    }
}
