package com.wuxin.test;

import com.wuxin.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxin001
 * @Date: 2022/04/20/10:08
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        User bean = (User) context.getBean("user", 1, "admin");
        System.out.println(bean);
    }
}
