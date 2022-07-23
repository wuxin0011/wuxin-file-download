package com.wuxin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/17 14:32
 * @Description: 事件日期工具类
 */
public class DateUtil {


    private static final String simpleFormat = "yyyy-MM-dd";

    private static final String format = "yyyy-MM-dd HH:mm:ss";


    public static String localTime() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String simpleDate() {
        return new SimpleDateFormat(simpleFormat).format(new Date());
    }

    public static String simpleDate(Date date) {
        return new SimpleDateFormat(simpleFormat).format(date);
    }

    public static String simpleDate(String date) {
        return new SimpleDateFormat(simpleFormat).format(date);
    }
}
