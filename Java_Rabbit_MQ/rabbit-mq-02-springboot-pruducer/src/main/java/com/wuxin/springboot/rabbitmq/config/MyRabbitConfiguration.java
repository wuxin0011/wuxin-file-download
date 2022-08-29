package com.wuxin.springboot.rabbitmq.config;

/**
 * @author: wuxin001
 * @date: 2022/8/25 17:36
 * @Description:
 */

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
public class MyRabbitConfiguration {

    public static final String QUEUE_EMAIL = "queue_email";
    public static final String QUEUE_SMS = "queue_sms";
    public static final String EXCHANGE_TOPICS="exchange_topics";
    public static final String ROUTINGKEY_EMAIL="inform.#.email.#";
    public static final String ROUTINGKEY_SMS="inform.#.sms.#";

    /**
     * 创建交换机
     */
    @Bean(EXCHANGE_TOPICS)
    public Exchange EXCHANGE_TOPICS(){
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS).durable(true).build();
    }

    /**
     * 声明邮件队列
     */
    @Bean(QUEUE_EMAIL)
    public Queue QUEUE_EMAIL(){
        return new Queue(QUEUE_EMAIL);
    }
    /**
     * 声明短信队列
     */
    @Bean(QUEUE_SMS)
    public Queue QUEUE_SMS(){
        return new Queue(QUEUE_SMS);
    }

    /**
     * 队列绑定交换机 同时指定routingkey
     */
    @Bean
    public Binding BINDING_QUEUE_EMAIL(@Qualifier(QUEUE_EMAIL) Queue queue,
                                              @Qualifier(EXCHANGE_TOPICS) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMAIL).noargs();
    }
    /**
     * 队列绑定交换机 同时指定routingkey
     */
    @Bean
    public Binding BINDING_ROUTINGKEY_SMS(@Qualifier(QUEUE_SMS) Queue queue,
                                          @Qualifier(EXCHANGE_TOPICS) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();
    }

}

