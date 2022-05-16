package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:49
 * @Description:
 */
public class SendSmsMailFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
