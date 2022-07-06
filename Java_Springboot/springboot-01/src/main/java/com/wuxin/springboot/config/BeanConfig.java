package com.wuxin.springboot.config;

import com.wuxin.springboot.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wuxin001
 * @date: 2022/6/29 10:22
 * @Description:
 */
@Configuration
public class BeanConfig {

    @Bean(name = "person")
    public Person p1(){
        return new Person();
    }
    // @Bean(name = "p2")
    // public Person person2(){
    //     return new Person();
    // }


}
