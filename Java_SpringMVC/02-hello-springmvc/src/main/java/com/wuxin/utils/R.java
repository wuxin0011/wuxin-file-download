package com.wuxin.utils;

import java.util.HashMap;

/**
 * @author: wuxin001
 * @date: 2022/7/15 12:14
 * @Description: 结果工具类
 */
public class R extends HashMap<String, Object> {

    private static final int successCode = 200;
    private static final int errorCode = 500;
    private static final String successMessage = "请求成功";
    private static final String errorMessage = "请求失败";
    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";

    private R() {

    }

    private R(int code, String message) {
        super.put(CODE, code);
        super.put(MESSAGE, message);
    }

    private R(int code, String message, Object data) {
        super.put(CODE, code);
        super.put(MESSAGE, message);
        super.put(DATA, data);
    }

    public static R getInstance() {
        return new R();
    }

    public static R ok() {
        return new R(successCode, successMessage);
    }

    public static R ok(String message, Object data) {
        return new R(successCode, message, data);
    }

    public static R ok(Object data) {
        return new R(successCode, successMessage, data);
    }


    public static R error() {
        return new R(errorCode, errorMessage);
    }

    public static R error(String message, Object data) {
        return new R(errorCode, message, data);
    }

    public static R error(int code, String message) {
        return new R(code, message);
    }


    public static R error(String message) {
        return new R(errorCode, message);
    }


    public static R error(Object data) {
        return new R(errorCode, errorMessage, data);
    }


    public static R create(int code, String message, Object data) {
        return new R(code, message, data);
    }


    @Override
    public Object put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
