package com.wuxin.design.factory.staticFactory;

import com.wuxin.design.factory.Sender;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:37
 * @Description: 静态工厂模式测试
 */
public class FactoryTest {

    public static void main(String[] args) {

        Sender sender = SendFactory.prodMail();
        sender.Send();

        Sender sender1 = SendFactory.prodSmsSender();
        sender1.Send();

    }
}
