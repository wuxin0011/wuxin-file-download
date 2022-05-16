package com.wuxin.design.bridge;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/17:25
 * @Description:
 */
public class AndroidPhone implements PhoneAction{

    @Override
    public void open() {
        System.out.println("安卓手机开机");
    }

    @Override
    public void close() {
        System.out.println("安卓手机关机");
    }

    @Override
    public void charge() {
        System.out.println("安卓手机充电");
    }
}
