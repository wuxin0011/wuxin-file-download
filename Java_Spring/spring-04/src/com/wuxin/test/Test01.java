package com.wuxin.test;

import com.wuxin.controller.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxin001
 * @Date: 2022/04/20/6:01
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-01.xml");
        UserController userContrller = context.getBean("userContrller", UserController.class);
        boolean login = userContrller.isLogin("admin", "null");
        if (login) {
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
