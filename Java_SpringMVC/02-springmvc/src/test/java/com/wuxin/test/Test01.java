package com.wuxin.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.wuxin.mapper.CategoryMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: wuxin001
 * @Description:
 */

// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration({"classpath:spring/**.xml"})
public class Test01 {



    @Test
    public void test02() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-servlet.xml");

        // 测试 mapper扫描的容器实例
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            Object bean = context.getBean(name);
            System.out.println(bean.getClass().getSimpleName());
        }

        // 测试数据库是否连接成功
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getConnection() + "，\n" + (dataSource.getConnection() != null ? "数据库连接成功！" : "数据库连接失败"));

        System.out.println(dataSource.getPassword());
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getDriver());
        System.out.println(dataSource.getUsername());
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("username")+"\t");
        }

        // 测试mapper
        CategoryMapper categoryMapper = context.getBean("categoryMapper", CategoryMapper.class);
        System.out.println(categoryMapper.getClass().getSimpleName());
        System.out.println(categoryMapper.list());


    }
}
