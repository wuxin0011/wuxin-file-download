package com.wuxin.test;

import com.wuxin.bean.User;
import com.wuxin.service.UserService;
import com.wuxin.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxin001
 * @Date: 2022/04/30/18:15
 * @Description:
 */
public class Demo01 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        String name = "admin";
        String password = "123456";
        boolean login = userService.login(name, password);
        if (login) {
            System.out.println("login success");
        } else {
            System.out.println("login fail");
        }


    }
}
