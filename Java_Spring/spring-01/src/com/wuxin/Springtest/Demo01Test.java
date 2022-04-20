package com.wuxin.Springtest;

import com.wuxin.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/21:26
 * @Description:
 */
public class Demo01Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user01", User.class);
        User user2 = context.getBean("user01", User.class);
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user2.equals(user));
    }
}
