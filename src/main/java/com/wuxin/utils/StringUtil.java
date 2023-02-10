package com.wuxin.utils;

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

    public static boolean isNotEmpty(String... strings) {
        for (String string : strings) {
            if (isEmpty(string)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(Integer obj) {
        return obj == null || obj == 0;
    }



    public static boolean isEmail(String email) {
        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return email.matches(regex);
    }

    public static boolean isPassword(String password) {
        return password.length() >= 4 && password.length() <= 20;
    }

    public static boolean isUsername(String username) {
        return username.length() >= 2 && username.length() <= 15;
    }


}


