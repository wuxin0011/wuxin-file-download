package com.wuxin.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wuxin.rabbitmq.util.RabbitMQUtil;

/**
 * @author: wuxin001
 * @date: 2022/8/29 10:07
 * @Description: 路由模式
 */
public class Producer {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
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
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            String queueName = channel.queueDeclare().getQueue();
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String severity = "消息安全通道 topic";
            String message = "hello topic 模式";

            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
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
