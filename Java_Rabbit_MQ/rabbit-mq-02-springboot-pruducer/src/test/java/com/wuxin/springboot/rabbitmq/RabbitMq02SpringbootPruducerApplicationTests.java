package com.wuxin.springboot.rabbitmq;

import com.wuxin.springboot.rabbitmq.config.MyRabbitConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RabbitMq02SpringbootPruducerApplicationTests {

    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {

        String message = "发送消息内容";

        rabbitTemplate.convertAndSend(MyRabbitConfiguration.EXCHANGE_TOPICS, "inform.email", message);

    }


}
