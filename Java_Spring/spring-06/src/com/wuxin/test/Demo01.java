package com.wuxin.test;

import com.wuxin.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxin001
 * @Date: 2022/04/30/18:15
 * @Description:
 */
public class Demo01 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1.equals(user2));
    }
}
