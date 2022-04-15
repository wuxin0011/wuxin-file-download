package com.wuxin.test;

import com.wuxin.utils.PropertiesUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/10:08
 * @Description:
 */
public class DemoTest {

    @Test
    void test01(){
        System.out.println(1);
    }

    @Test
    void test02() throws Exception {
        PropertiesUtils.read();
    }


}
