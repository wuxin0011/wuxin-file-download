package com.wuxin.springboot;

import com.wuxin.springboot.bean.SystemConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest
class Springboot01ApplicationTests {

    @Autowired
    public SystemConfig systemConfig;

    @Test
    void contextLoads() {
        System.out.println("通过spring创建对象"+systemConfig);
        systemConfig = new SystemConfig();
        System.out.println("通过自己创建对象"+systemConfig);
    }

}
