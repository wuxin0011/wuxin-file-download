package com.wuxin.design.bridge;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/17:24
 * @Description:
 */
public interface PhoneAction {

    /**
     * 手机关机
     */
    void open();

    /**
     * 开机
     */
    void close();

    /**
     * 手机充电
     */
    void charge();
}
