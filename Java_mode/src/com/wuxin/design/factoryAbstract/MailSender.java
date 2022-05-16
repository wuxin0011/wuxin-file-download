package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:30
 * @Description: 邮件实现方法一
 */
public class MailSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}
