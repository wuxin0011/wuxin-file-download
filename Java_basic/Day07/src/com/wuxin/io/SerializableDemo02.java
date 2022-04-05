package com.wuxin.io;

import java.io.FileReader;
import java.util.Properties;

/**
 * @Author: wuxin001
 * @Date: 2022/03/28/12:30
 * @Description: Properties类代表一个持久的特性。的 Properties可以保存到流或流中加载。属性列表中的每个键和它的相应值是一个字符串。
 * 属性列表可以包含另一个属性列表作为它的“默认”；如果在原始属性列表中没有找到属性键，则搜索该第二个属性列表。
 */
public class SerializableDemo02 {

    // Properties
    public static void main(String[] args) throws Exception {
        // 读取users.txt中数据
        testProperties();
        testProperties02();
    }

    static void testProperties() throws Exception {
        FileReader fileReader = new FileReader("Day07/user.ini");
        // 读取配置文件信息
        Properties properties = new Properties();
        properties.load(fileReader);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username=" + username);
        System.out.println("password=" + password);
    }

    static void testProperties02() throws Exception {
        FileReader fileReader = new FileReader("Day07/user.properties");
        // 读取配置文件信息
        Properties properties = new Properties();
        properties.load(fileReader);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String age = properties.getProperty("age");
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        System.out.println("age=" + age);
    }
}
