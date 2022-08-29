package com.wuxin.springboot.rabbitmq.rabbitmq02springbootconsume.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wuxin001
 * @date: 2022/8/29 10:48
 * @Description:
 */
@SuppressWarnings("all")
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_EMAIL = "queue_email";
    public static final String QUEUE_SMS = "queue_sms";
    public static final String EXCHANGE_TOPICS = "exchange_topics";
    public static final String ROUTINGKEY_EMAIL = "inform.#.email.#";
    public static final String ROUTINGKEY_SMS = "inform.#.sms.#";

    /**
     * 声明交换机
     *
     * @return 交换机
     */
    @Bean(EXCHANGE_TOPICS)
    public Exchange EXCHANGE_TOPICS() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS).durable(true).build();
    }


    /**
     * 邮件服务队列
     */
    @Bean(QUEUE_EMAIL)
    public Queue QUEUE_EMAIL() {
        return new Queue(QUEUE_EMAIL);
    }

    /**
     * 绑定短信服务队列
     */
    @Bean(QUEUE_SMS)
    public Queue QUEUE_SMS() {
        return new Queue(QUEUE_SMS);
    }


    /**
     * 邮件队列服务绑定交换机
     *
     * @param queue    队列
     * @param exchange 交换机
     */
    @Bean
    public Binding BINDING_QUEUE_EMAIL(@Qualifier(QUEUE_EMAIL) Queue queue,
                                              @Qualifier(EXCHANGE_TOPICS) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMAIL).noargs();
    }

    /**
     * 短信队列绑定交换机 指定短信服务的routingkey
     *
     * @param queue    短信 sms 队列
     * @param exchange 交换机
     */
    @Bean
    public Binding BINDING_ROUTINGKEY_SMS(@Qualifier(QUEUE_SMS) Queue queue,
                                          @Qualifier(EXCHANGE_TOPICS) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();
    }

}
