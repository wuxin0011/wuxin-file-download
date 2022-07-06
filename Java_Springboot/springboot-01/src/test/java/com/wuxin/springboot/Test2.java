package com.wuxin.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: wuxin001
 * @date: 2022/6/29 9:45
 * @Description:
 */
@SpringBootTest(classes = {Test2.class})
public class Test2 {
    @Test
    void testPerson() {
        System.out.println(System.nanoTime());
    }
}
