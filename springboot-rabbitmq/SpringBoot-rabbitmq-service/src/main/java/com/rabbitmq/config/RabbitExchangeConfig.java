package com.rabbitmq.config;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitExchangeConfig {
    @Autowired
    private RabbitAdmin rabbitAdmin;

    public RabbitExchangeConfig() {
    }

    @Bean
    FanoutExchange contractFanoutExchange() {
        FanoutExchange fanoutExchange = new FanoutExchange("com.exchange.fanout");
        this.rabbitAdmin.declareExchange(fanoutExchange);
        return fanoutExchange;
    }

    @Bean
    TopicExchange contractTopicExchangeDurable() {
        TopicExchange contractTopicExchange = new TopicExchange("com.exchange.topic");
        this.rabbitAdmin.declareExchange(contractTopicExchange);
        return contractTopicExchange;
    }

    @Bean
    DirectExchange contractDirectExchange() {
        DirectExchange contractDirectExchange = new DirectExchange("com.exchange.direct");
        this.rabbitAdmin.declareExchange(contractDirectExchange);
        return contractDirectExchange;
    }

    @Bean
    Queue queueHello() {
        Queue queue = new Queue("com.queue.notify.hello", true);
        this.rabbitAdmin.declareQueue(queue);
        return queue;
    }

}