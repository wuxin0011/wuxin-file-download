package com.wuxin.logical;

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/21:44
 * @Description:
 */
public class LogicalDemo01 {

    public static void main(String[] args) {
        int a = 100;
        int b = 29;
        System.out.println(a>b);
        System.out.println(!(a>b));
        System.out.println(!!(a>b));
        System.out.println(!!!(a>b));
        System.out.println(!!!!(a>b));

    }
}
