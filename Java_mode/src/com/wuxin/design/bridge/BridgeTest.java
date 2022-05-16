package com.wuxin.design.bridge;

import com.sun.deploy.panel.AndOrRadioPropertyGroup;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/17:30
 * @Description:
 */
public class BridgeTest {

    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        // ios手机操作实现
        bridge.setPhone(new IOSPhone());
        bridge.open();
        bridge.close();
        bridge.charge();

        // Android 手机操作实现方式
        bridge.setPhone(new AndroidPhone());
        bridge.open();
        bridge.close();
        bridge.charge();
    }
}
