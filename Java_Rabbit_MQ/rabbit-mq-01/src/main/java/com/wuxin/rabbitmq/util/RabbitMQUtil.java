package com.wuxin.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wuxin001
 * @Description:
 */
public class RabbitMQUtil {


    public static void close(Connection connection) {
        if (connection != null && connection.isOpen()) {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(Channel connection) {
        if (connection != null && connection.isOpen()) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static String date() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
