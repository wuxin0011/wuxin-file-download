package com.wuxin.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author: wuxin001
 * @Date: 2022/04/16/22:27
 * @Description: 连接数据库工具类
 */
public class DBUtils {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("application.properties");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String username = bundle.getString("username");
    private static String password = bundle.getString("password");

    static {

        // 放在静态代码块中，类加载时加载对象
        try {
            Class<?> aClass = Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库
     *
     * @return 返回con
     * @throws SQLException 连接失败抛出异常
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


    /**
     * 关闭连接
     *
     * @param con 连接对象
     * @param ps         执行对象
     * @param rs         结果集
     * @throws SQLException 异常
     */
    public static void close(Connection con, Statement ps, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }


}
