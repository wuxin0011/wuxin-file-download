package com.wuxin.aop;

/**
 * @Author: wuxin001
 * @Date: 2022/04/30/18:09
 * @Description:
 */
public class AopConfig {

    public boolean before() {
        System.out.println("before");
        return true;
    }

    public Object around(Object result) throws Throwable {
        System.out.println("before around==========");
        return result;
    }

    public void afterRunning() {
        System.out.println("afterReturning");
    }

    public void afterThrowing(Exception e) {
        System.out.println("afterThrowing");
    }

    public void after() {
        System.out.println("after");
    }

}
