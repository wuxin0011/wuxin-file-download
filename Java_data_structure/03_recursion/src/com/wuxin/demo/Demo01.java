package com.wuxin.demo;

/**
 * @Author: wuxin001
 * @Date: 2022/04/22/14:51
 * @Description: 递归 01 递归的调用机制
 */
public class Demo01 {

    public static void main(String[] args) {

        test(5);
        System.out.println("=================");
        test02(5);
    }

    public static void test(int i) {
        if (i > 2) {
            test(i - 1);
        }
        System.out.println("i=" + i);
    }

    public static void test02(int i) {
        if (i > 2) {
            test02(i - 1);
        } else {
            System.out.println("i2=" + i);
        }


    }
}
