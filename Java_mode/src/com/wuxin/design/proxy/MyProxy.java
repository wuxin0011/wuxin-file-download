package com.wuxin.design.proxy;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:17
 * @Description: 代理模式
 */
public class MyProxy implements Sourceable {

    private Sourceable sourceable;


    @Override
    public void method() {
        before();
        sourceable.method();
        atfer();
    }


    private void atfer() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }

    public MyProxy() {
        this.sourceable = new Sources();
    }
}
