package com.wuxin.design.factory.improve;

import com.wuxin.design.factory.MailSender;
import com.wuxin.design.factory.Sender;
import com.wuxin.design.factory.SmsSender;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:32
 * @Description:
 */
public class SendFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }

}
