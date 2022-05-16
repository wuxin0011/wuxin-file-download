package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:31
 * @Description: sms邮件实现
 */
public class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is smsender!");
    }
}
