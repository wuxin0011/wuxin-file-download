package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/2:05
 * @Description: 优化
 */
public class BuilderTest {

    public static void main(String[] args) {

        new SendFactory(new SendMailFactory()).Send();
        new SendFactory(new SendSmsMailFactory()).Send();

        // 添加新功能
        new SendFactory(new SendNewFactory()).Send();
    }
}
