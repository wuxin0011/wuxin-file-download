package com.wuxin.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.wuxin.rabbitmq.util.RabbitMQUtil;

/**
 * @Author: wuxin001
 * @Description: 路由模式
 */
public class Consumer {

    public static final String EXCHANGE_NAME = "direct_logs";


    public static void main(String[] args) {
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
            // 创建连接
            connection = connectionFactory.newConnection();
            // 创建通道
            channel = connection.createChannel();
            // 获取队列名称
            String queueName = channel.queueDeclare().getQueue();
            System.out.println(EXCHANGE_NAME + " [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(EXCHANGE_NAME + " [x] Received '" + message + "'");
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
                System.out.println("\"queueName,\""+queueName+",\"deliverCallback\""+deliverCallback+"\",consumerTag\""+consumerTag);
            });
            System.in.read();
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
