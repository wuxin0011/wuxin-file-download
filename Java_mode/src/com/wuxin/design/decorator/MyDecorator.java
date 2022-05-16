package com.wuxin.design.decorator;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:17
 * @Description:
 */
public class MyDecorator implements Sourceable {

    private Sourceable sourceable;


    @Override
    public void method() {
        System.out.println("before ...");
        sourceable.method();
        System.out.println("after ...");
    }

    public MyDecorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }
}
