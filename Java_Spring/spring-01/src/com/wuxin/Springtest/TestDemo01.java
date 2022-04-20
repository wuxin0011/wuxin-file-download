package com.wuxin.Springtest;

import com.wuxin.bean.Person;
import com.wuxin.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/21:12
 * @Description:
 */
public class TestDemo01 {

    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user01", User.class);
        User user1 = context.getBean("user01", User.class);
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user1.equals(user));
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user02 = context.getBean("user02", User.class);
        System.out.println(user02);

    }
}
