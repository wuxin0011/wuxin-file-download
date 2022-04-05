package com.wuxin.Demo;

import com.wuxin.Demo.bean.User;

/**
 * @Author: wuxin001
 * @Date: 2022/04/01/13:10
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println("Demo02 main 方法 开始执行");
        User user = new User();
        System.out.println("userid=" + user.userid);
        System.out.println("name=" + user.name);
        System.out.println("password=" + user.password);

        // 赋值
        user.userid = 1;
        user.name = "admin";
        user.password = "123456";

        System.out.println("userid=" + user.userid);
        System.out.println("name=" + user.name);
        System.out.println("password=" + user.password);

        System.out.println("Demo02 main 方法 结束");

        // 输出结果
        // Demo02 main 方法 开始执行
        // userid=null
        // name=null
        // password=null
        // userid=1
        // name=admin
        // password=123456
        // Demo02 main 方法 结束
    }
}
