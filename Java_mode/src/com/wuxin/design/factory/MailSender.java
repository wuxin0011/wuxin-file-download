package com.wuxin.design.factory;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:30
 * @Description:
 */
public class MailSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}
