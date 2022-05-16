package com.wuxin.design.factory.odrinary;

import com.wuxin.design.factory.Sender;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:32
 * @Description: 普通工厂模式测试
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sms = sendFactory.produce("sms");
        sms.Send();

        Sender mail = sendFactory.produce("mail");
        mail.Send();
    }
}
