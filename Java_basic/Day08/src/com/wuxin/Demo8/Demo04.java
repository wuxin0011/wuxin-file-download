package com.wuxin.Demo8;

/**
 * @Author: wuxin001
 * @Date: 2022/04/01/20:33
 * @Description: 执行顺序
 */
public class Demo04 {

    public static final int i = 100;

    private static final String word = "%s\t%s";

    {
        // 非静态代码快不会在类加载时候执行
        System.out.println("实例语句块执行...");
    }

    static {
        // 类加载时候执行并且在main方法执行之前 在构造方法执行的时候执行的
        System.out.println("c..." + i);
    }


    public static void main(String[] args) {
        System.out.println("main start...");
        new Demo04();
        System.out.println("main end...");

        // 输出结果为
        // c ... 100
        // b ...
        // main start...
        // 实例语句块执行...
        // a ...
        // demo create ....
        // main end...
    }

    public Demo04() {
        System.out.println("demo create ....");
    }


    void say() {
        System.out.println("say ...");
        System.out.printf((word) + "%n", "hello", "world");
    }

    {
        System.out.println("a...");
    }

    static {
        // 类加载时候执行并且在main方法执行之前 从上到下执行
        System.out.println("b...");
    }
}
