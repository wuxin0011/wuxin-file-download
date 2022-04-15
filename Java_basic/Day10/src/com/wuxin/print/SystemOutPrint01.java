package com.wuxin.print;

/**
 * @Author: wuxin001
 * @Date: 2022/04/14/23:24
 * @Description: 探究 System.out.println()
 */
public class SystemOutPrint01 {

    public static void main(String[] args) {
        // 能够输出这些信息说明这些方法重载了，能够对应输出 各种个样式的类型数据
        System.out.println("hello");
        System.out.println(1);
        System.out.println(1.2);
        System.out.println(1.2f);
        System.out.println(1L);
        System.out.println('A');
        System.out.println('c');
        System.out.println(new Object());
    }
}
