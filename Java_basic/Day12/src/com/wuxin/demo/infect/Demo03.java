package com.wuxin.demo.infect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/11:14
 * @Description: 通过读取配置文件内容 创建不同实例对象
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {
        // 读取配置文件内容
        FileReader reader = new FileReader("Day12/class.properties");
        Properties properties = new Properties();
        // 读取配置文件
        properties.load(reader);
        // 关闭
        reader.close();
        // 通过key读取配置文件内容
        String className = (String) properties.get("className");
        System.out.println(className);

        // 通过类包名反射对象
        Class<?> aClass = Class.forName(className);
        System.out.println(aClass);

        // 创建对象
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

    }
}
