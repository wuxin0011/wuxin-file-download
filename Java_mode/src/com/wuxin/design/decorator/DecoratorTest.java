package com.wuxin.design.decorator;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:19
 * @Description:
 */
public class DecoratorTest {

    public static void main(String[] args) {
        MyDecorator myDecorator = new MyDecorator(new Sources());
        myDecorator.method();
    }
}
