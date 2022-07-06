package com.wuxin.config;

import com.wuxin.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wuxin001
 * proxyBeanMethods = true 是否交给容器管理，如果交给容器获取的是单实例，如果配置false，每次获取的是新实例
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean
    public Cat cat() {
        return new Cat("tomcat");
    }
}
