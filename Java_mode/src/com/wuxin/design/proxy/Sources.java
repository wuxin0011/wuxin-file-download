package com.wuxin.design.proxy;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:16
 * @Description:
 */
public class Sources implements Sourceable {

    @Override
    public void method() {
        System.out.println("通过代理模式实现方法 。。。");
    }
}
