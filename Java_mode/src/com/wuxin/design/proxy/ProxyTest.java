package com.wuxin.design.proxy;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:19
 * @Description: 代理模式测试
 */
public class ProxyTest {

    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        myProxy.method();
    }
}
