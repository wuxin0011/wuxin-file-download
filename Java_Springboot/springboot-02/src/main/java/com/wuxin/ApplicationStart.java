package com.wuxin;

import com.wuxin.bean.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: wuxin001
 * @date: 2022/7/4 17:52
 * @Description: 程序启动入口
 */
@SpringBootApplication(proxyBeanMethods = false)
public class ApplicationStart {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationStart.class, args);
        Cat cat1 = run.getBean("cat", Cat.class);
        Cat cat2 = run.getBean("cat", Cat.class);
        System.out.println(cat1 == cat2);
    }
}
