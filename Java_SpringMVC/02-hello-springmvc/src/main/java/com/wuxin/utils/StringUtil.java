package com.wuxin.utils;

import sun.security.provider.MD5;

/**
 * @author: wuxin001
 * @date: 2022/7/16 23:42
 * @Description:
 */
public class StringUtil {
    public final static String EMPTY_STR = "";

    public static boolean isEmpty(String s) {
        return (s == null) || EMPTY_STR.equals(s.trim());
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(Integer obj) {
        return obj == null || obj == 0;
    }

    public static boolean isNull(Long obj) {
        return obj == null || obj == 0;
    }

    public static boolean isEqual(Object o1, Object o2) {
        return o1 == o2;
    }


    public static boolean isEmail(String email) {
        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return email.matches(regex);
    }

    public static boolean isPassword(String password) {
        return password.length() < 4 || password.length() > 20;
    }

    public static String encryption(String password) {
        MD5 md5 = new MD5();

        return null;
    }

    public static void main(String[] args) {
        String email = "2191377759@qq.com";
        System.out.println(isEmail(email));
    }

}


