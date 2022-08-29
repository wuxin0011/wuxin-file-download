package com.wuxin.springboot.rabbitmq.rabbitmq02springbootconsume.handler;


import com.rabbitmq.client.Channel;
import com.wuxin.springboot.rabbitmq.rabbitmq02springbootconsume.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @author: wuxin001
 * @date: 2022/8/29 10:58
 * @Description:
 */
@Component
public class ReceiveHandler {
    //监听email队列
    @RabbitListener(queues = {RabbitMQConfig.QUEUE_EMAIL})
    public void receive_email(Object msg, Message message, Channel channel) {
        System.out.println("QUEUE_EMAIL msg" + msg);
        System.out.println("发送消息内容是:"+message);
        System.out.println("消息通道:"+channel);
    }

    //监听sms队列
    @RabbitListener(queues = {RabbitMQConfig.QUEUE_SMS})
    public void receive_sms(Object msg, Message message, Channel channel) {
        System.out.println("QUEUE_SMS msg" + msg);
        System.out.println("发送消息内容是:"+message);
        System.out.println("消息通道:"+channel);
    }

}