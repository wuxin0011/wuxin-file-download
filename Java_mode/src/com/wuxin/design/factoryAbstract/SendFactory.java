package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/2:02
 * @Description:
 */
public class SendFactory implements Sender{

    private Provider provider;

    public SendFactory(Provider provider) {
        this.provider = provider;
    }

    @Override
    public void Send() {
        this.provider.produce().Send();
    }
}
