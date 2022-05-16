package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/2:05
 * @Description:
 */
public class SendNewFactory implements Provider{

    @Override
    public Sender produce() {
        return new NewSend();
    }
}
