package com.wuxin.DataType;

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/17:27
 * @Description:
 */
public class DataType01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 92;
        System.out.println(a + b);

        char c = 90;
        System.out.println(c); // Z
        char d = 'Z';
        System.out.println(d);
        System.out.println(d == c);
        System.out.println((char) b);

        System.out.println(a + c);

        byte b2 = 10;
        System.out.println(b2);
        System.out.println(b2 + b); // 102

    }
}
