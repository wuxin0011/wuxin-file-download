package com.wuxin.test;

import com.wuxin.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

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

        boolean userAop = context.containsBean("userAop");
        System.out.println(userAop);

        String[] beanNamesForType = context.getBeanNamesForType(User.class);
        System.out.println(Arrays.toString(beanNamesForType));

        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment);
        System.out.println(environment.getSystemEnvironment());

        System.out.println(environment.getPropertySources());

    }
}
