package com.wuxin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Administrator
 */
@SpringBootApplication
public class SpringbootStart {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootStart.class, args);
        System.out.println(run.getEnvironment());
        System.out.println(run.getApplicationStartup());
    }

}
