package com.wuxin.design.bridge;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/17:29
 * @Description:
 */
public class MyBridge extends Bridge{
    @Override
    public void open() {
        getAction().open();
    }

    @Override
    public void close() {
        getAction().close();
    }

    @Override
    public void charge() {
        getAction().charge();
    }
}
