package com.wuxin.hello;

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/16:59
 * @Description:
 */
public class DataByte {

    public static void main(String[] args) {
        byte b = 1;
        int i = 1;
        System.out.println(b);
        System.out.println(i);
        System.out.println(b == i); // true

        short s = 100;
        System.out.println(s);

        long l = 10000L;
        System.out.println(l);
        System.out.println(l == 10000); // true

        float f = 100F;
        float f2 = 10.909F;
        System.out.println(f); // 100.0
        System.out.println(f2); // 10.909


        double d = 199.9192313D;
        System.out.println(d); // 199.9192313

        char ch = 'a';
        System.out.println(ch);

        boolean flag = false;
        System.out.println(flag);
    }
}
