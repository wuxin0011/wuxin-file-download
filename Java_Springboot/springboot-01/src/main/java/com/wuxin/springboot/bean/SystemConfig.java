package com.wuxin.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: wuxin001
 * @date: 2022/6/29 9:21
 * @Description:
 */
@Component
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "config")
public class SystemConfig {

    @Value("${config.name}")
    private String name;
    @Value("${config.configPath}")
    private String configPath;
    @Value("${config.total}")
    private Integer total;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "name='" + name + '\'' +
                ", configPath='" + configPath + '\'' +
                ", total=" + total +
                '}';
    }
}
