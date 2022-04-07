package com.wuxin.Demo8;

import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/04/01/22:33
 * @Description:
 */
public class Demo06 {
    public static void main(String[] args) {
        System.out.println("args=>"+ Arrays.toString(args));
        User admin = new User("admin");
        admin.shop();
        admin.go();
        User.leave();
        User.to();
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    void shop() {
        System.out.println(name + "在购物");
    }

    void go() {
        System.out.println(this.name + "在购物");
    }

    /**
     * this 不能使用在静态方法中 原因 ：静态方法不需要使用当前对象也可以调用
     * 静态方法 类可以访问，存在与类加载中 对象创建也可以访问
     */
    static void leave() {
        // System.out.println("this=>"+this.name);
        // System.out.println(name);
        System.out.println("leave...");
    }

    public static void to() {
        System.out.println("to...");
        // System.out.println(name);
    }
}