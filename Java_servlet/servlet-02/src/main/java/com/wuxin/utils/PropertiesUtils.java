package com.wuxin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/9:54
 * @Description:读取配置文件的工具类
 */
public class PropertiesUtils {

    private final static String PATH = "application.properties";
    private final static String Default_Path = "src/main/resources/application.properties";

    public static void read() throws Exception {

        File file = new File(Default_Path);
        System.out.println(file);
        if (file.exists()) {
            throw new Exception("文件未找到");
        }

        FileInputStream in = new FileInputStream(file);


        Properties properties = new Properties();
        properties.load(in);
        in.close();

        String username = properties.getProperty("username");
        System.out.println(username);
    }

}
