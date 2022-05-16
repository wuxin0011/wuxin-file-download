package com.wuxin.design.factory.improve;

import com.wuxin.design.factory.Sender;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:32
 * @Description: 普通工厂模式改进方式
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.Send();

        Sender sender1 = factory.produceSms();
        sender1.Send();
    }
}
