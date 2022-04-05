package com.wuxin.Demo;

/**
 * @Author: wuxin001
 * @Date: 2022/04/01/12:43
 * @Description: 检查方法执行顺序以及释放顺序
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("main 方法执行");
        new Demo01().m1(100); // -> 存放在内容（栈中） 先进后出
        System.err.println("main 方法被释放了");
        // 输出结果
        // main 方法执行
        // m1被调用了
        // x=>100
        // m2被调用了
        // x=>100
        // m3被调用了
        // x=>100
        // m3被释放了
        // m2被释放了
        // m1被释放了
        // main 方法被释放了
    }

    void m1(int x) {
        System.out.println("m1被调用了");
        System.out.println("x=>" + x);
        m2(x);
        System.err.println("m1被释放了");
    }

    void m2(int x) {
        System.out.println("m2被调用了");
        System.out.println("x=>" + x);
        m3(x);
        System.err.println("m2被释放了");
    }

    void m3(int x) {
        System.out.println("m3被调用了");
        System.out.println("x=>" + x);
        System.err.println("m3被释放了");
    }
}
