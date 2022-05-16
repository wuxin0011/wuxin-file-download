package com.wuxin.design.factory.odrinary;

import com.wuxin.design.factory.MailSender;
import com.wuxin.design.factory.Sender;
import com.wuxin.design.factory.SmsSender;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:32
 * @Description:
 */
public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

}
