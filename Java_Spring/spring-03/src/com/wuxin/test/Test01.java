package com.wuxin.test;

import com.wuxin.controller.UserController;
import com.wuxin.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxin001
 * @Date: 2022/04/20/6:01
 * @Description:
 */
public class Test01 {

    @Test
    public void test01() {
        // 无法通过这种方式获取bean  userService = null
        UserController userController = new UserController();
        UserService userService = userController.getUserService();
        System.out.println(userService);
    }

    @Test
    public void test02() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-02.xml");
        UserController userController = context.getBean("userController", UserController.class);
        boolean islogin = userController.isLogin("admin", "123456");
        if (islogin) {
            System.out.println("登录成功");
        } else {
            System.err.println("登录失败");
        }
    }

    @Test
    public void test03() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-01.xml");
        UserController userController = context.getBean("userController", UserController.class);
        boolean islogin = userController.isLogin("admin", "123456");
        if (islogin) {
            System.out.println("登录成功");
        } else {
            System.err.println("登录失败");
        }
    }


}
