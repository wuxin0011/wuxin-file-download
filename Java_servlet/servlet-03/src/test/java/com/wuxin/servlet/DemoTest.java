package com.wuxin.servlet;

import com.wuxin.util.DBUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: wuxin001
 * @Date: 2022/04/17/13:09
 * @Description:
 */
public class DemoTest {

    @Test
    void test01() throws SQLException {
        // 测试是否能够连接数据库
        Connection connection = DBUtils.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
