package com.wuxin.test;

import com.wuxin.controller.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: wuxin001
 * @Date: 2022/04/20/6:01
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) throws SQLException {
        // login();

        // read dataSource
        dataSrouce();
    }

    public static void login() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-01.xml");
        UserController userController = context.getBean("userController", UserController.class);
        boolean login = userController.isLogin("admin", "null");
        if (login) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    public static void dataSrouce() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-01.xml");
        SimpleDriverDataSource myDataSource = context.getBean("myDataSource", SimpleDriverDataSource.class);
        System.out.println(myDataSource); // org.springframework.jdbc.datasource.SimpleDriverDataSource@727eb8cb
        Connection connection = myDataSource.getConnection();
        System.out.println(connection);  //  com.mysql.cj.jdbc.ConnectionImpl@3bde62ff 测试通过
    }
}
