package com.wuxin.exception;

/**
 * @author: wuxin001
 * @date: 2022/7/17 11:13
 * @Description:
 */
public class UnauthenticatedException extends RuntimeException {

    public UnauthenticatedException() {
        super("没有权限执行该操作！");
    }
}