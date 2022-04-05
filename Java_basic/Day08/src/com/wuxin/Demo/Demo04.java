package com.wuxin.Demo;

import java.sql.SQLOutput;

/**
 * @Author: wuxin001
 * @Date: 2022/04/01/20:33
 * @Description: 执行顺序
 */
public class Demo04 {

    public static final int i = 100;

    private static final String word = "%s\t%s";

    {
        System.out.println("hello");
    }

    static {
        // 类加载时候执行并且在main方法执行之前
        System.out.println("hello2 {}" + i);
    }

    static {
        // 类加载时候执行并且在main方法执行之前 从上到下执行
        System.out.println("hello1 {}");
    }


    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();
        demo04.say();

        hello();
        System.out.println("main ...");

    }

    static void hello() {
        System.out.println("hello()");
    }

    void say() {
        System.out.println("say ...");
        System.out.printf((word) + "%n", "hello", "world");
    }
}
