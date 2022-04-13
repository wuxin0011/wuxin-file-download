package com.wuxin.demo.infect;

import java.io.FileReader;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/11:23
 * @Description:
 */
public class Demo04 {
    public static void main(String[] args) throws Exception{
        // 获取该类的相对路径
        // Map<String, String> getenv = System.getenv();
        // System.out.println(getenv);

        Class<Demo04> aClass = Demo04.class;
        // 获取当前项类的类加载器
        URL resource = aClass.getClassLoader().getResource("file.properties");
        assert resource != null;
        String path = resource.getPath();
        System.out.println(path);

        // 读取配置文件内容
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        // 读取配置文件内容
        String name = (String) properties.get("name");
        System.out.println(name);
    }


}
