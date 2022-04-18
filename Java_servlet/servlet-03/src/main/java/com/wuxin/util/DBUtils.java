package com.wuxin.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author: wuxin001
 * @Date: 2022/04/16/22:27
 * @Description: 连接数据库工具类
 */
public class DBUtils {

    // 注意使用该方法读取配置文件不需要添加配置文件后缀名，但配置文件后缀必须是  .properties 解释看下面注释
    private static final ResourceBundle bundle = ResourceBundle.getBundle("application");
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
/**
 * 解释 为什么不需要添加后缀，而且添加后缀就报错 源代码
 *          public ResourceBundle newBundle(String baseName, Locale locale, String format,
 *                                         ClassLoader loader, boolean reload)
 *                     throws IllegalAccessException, InstantiationException, IOException {
 *
 *                 final String resourceName = toResourceName0(bundleName, "properties");
 *             return bundle;
 *         }
 *
 *         判断名称是否为null，或者是否合法
 *          private String toResourceName0(String bundleName, String suffix) {
 *             // application protocol check
 *             if (bundleName.contains("://")) {
 *                 return null;
 *             } else {
 *                 return toResourceName(bundleName, suffix);
 *             }
 *         }
 *     }
 *
 *           名字是由这段代码实现拼接的
*             public final String toResourceName(String bundleName, String suffix) {
*                   StringBuilder sb = new StringBuilder(bundleName.length() + 1 + suffix.length());
*                  sb.append(bundleName.replace('.', '/')).append('.').append(suffix);
*                  return sb.toString();
*            }
 */