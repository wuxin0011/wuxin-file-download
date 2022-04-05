package com.wuxin.demo;

import java.io.Console;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: wuxin001
 * @Date: 2022/3/24/21:19
 * @Description: system类使用
 */
public class SystemDemo01 {
    public static void main(String[] args) {
       // test01();
        test02();
    }


    static void test01(){
        long l = System.currentTimeMillis();
        System.out.println("当前时间"+l+"ms");

        Console console = System.console();
        System.out.println("console:"+console);

        // 返回当前系统环境的一个不可修改的字符串的Map视图。
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv);

        String java = System.getenv("JAVA_HOME");
        System.out.println(java); // D:\environment\java\jdk\bin

        // 确定当前系统属性
        Properties properties = System.getProperties();
        System.out.println(properties);
        // 确定当前系统属性 指定
        String property = System.getProperty("java.library.path");
        System.out.println(property);
    }


    static void test02(){
        // 获取系统安全接口
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);
    }

}
