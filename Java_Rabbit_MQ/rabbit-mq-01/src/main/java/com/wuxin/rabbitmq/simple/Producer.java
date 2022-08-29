package com.wuxin.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wuxin.rabbitmq.util.RabbitMQUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @Author: wuxin001
 * @Description:
 */
public class Producer {

    public static void main(String[] args) {

        // ip port
        // 1、创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2、创建连接connection
        connectionFactory.setHost("192.168.56.40");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        // 3、获取连接通道
        Connection connection = null;
        Channel channel = null;
        try {
            // 创建连接 connection
            connection = connectionFactory.newConnection("生产者");
            // 创建channel连接通道
            channel = connection.createChannel();
            String queueName = "queue1";
            // 4、通过创建交换机、神明队列、绑定关系、路由key，发送消息、接收消息
            /**
             * 参数说明
             * @params1 队列名称
             * @params2 是否持久化
             * @params3 排他性，是否独立（是否是一个独占队列）
             * @params4 是否自动删除，随着最后一个消费者消息完毕以后是否自动把队列自动删除
             * @params5 携带附带参数
             */
            channel.queueDeclare(queueName, false, false, false, null);
            // 5、准备消息内容
            String message = "恭喜你！接收到一条rabbitMq消息！" + RabbitMQUtil.date();
            // 6、发送消息队列 queue

            channel.basicPublish("", queueName, null, message.getBytes());
            // 消息发送成功
            System.out.println("消息发送成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // 7、关闭通道
            RabbitMQUtil.close(channel);
            // 8、关闭连接
            RabbitMQUtil.close(connection);

        }


    }
}
