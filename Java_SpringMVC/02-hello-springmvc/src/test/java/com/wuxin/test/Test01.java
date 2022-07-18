package com.wuxin.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.wuxin.mapper.UserMapper;
import com.wuxin.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: wuxin001
 * @Description:
 */

public class Test01 {


    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.list("");
        System.out.println(users);
    }

    @Test
    public void test02() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-dao.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getConnection());

        // UserMapper userMapper = context.getBean("userMapper",UserMapper.class);
        // System.out.println(userMapper);
        //
        // List<User> list = userMapper.list("");
        // System.out.println(list);


    }


    @Test
    public void test03() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-service.xml");
        // UserMapper bean = context.getBean(UserMapper.class);
        // System.out.println(bean);

        Object dataSource = context.getBean("categoryController");
        System.out.println(dataSource);


    }


}
