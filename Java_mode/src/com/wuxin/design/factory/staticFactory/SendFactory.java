package com.wuxin.design.factory.staticFactory;

import com.wuxin.design.factory.MailSender;
import com.wuxin.design.factory.Sender;
import com.wuxin.design.factory.SmsSender;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:38
 * @Description:
 */
public class SendFactory {

    public static Sender prodMail(){
        return new MailSender();
    }

    public static Sender prodSmsSender(){
        return new SmsSender();
    }
}
