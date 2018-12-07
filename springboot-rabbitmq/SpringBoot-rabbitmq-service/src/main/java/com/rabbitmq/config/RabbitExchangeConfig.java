package com.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.util.QueueConstant;

@Configuration
public class RabbitExchangeConfig {
    @Autowired
    private RabbitAdmin rabbitAdmin;

    public RabbitExchangeConfig() {
    }
    
    
    /**
     * 不处理路由键。你只需要简单的将队列绑定到交换机上。一个发送到交换机的消息都会被转发到与该交换机绑定的所有队列上。很像子网广播，每台子网内的主机都获得了一份复制的消息。Fanout交换机转发消息是最快的。
     * @return
     */
    @Bean
    FanoutExchange contractFanoutExchange() {
        FanoutExchange fanoutExchange = new FanoutExchange(QueueConstant.EXCHANGE_FANOUT);
        this.rabbitAdmin.declareExchange(fanoutExchange);
        return fanoutExchange;
    }
    
    /**
     * 将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但是“audit.*”
	 * 只会匹配到“audit.irs” 默认：, durable = true, autoDelete = false
     * @return
     */
    @Bean
    TopicExchange contractTopicExchangeDurable() {
        TopicExchange contractTopicExchange = new TopicExchange(QueueConstant.EXCHANGE_TOPIC);
        this.rabbitAdmin.declareExchange(contractTopicExchange);
        return contractTopicExchange;
    }
    
    /**
     * * 处理路由键。需要将一个队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配。这是一个完整的匹配。如果一个队列绑定到该交换机上要求路由键
	 * “dog”，则只有被标记为“dog”的消息才被转发，不会转发dog.puppy，也不会转发dog.guard，只会转发dog
     * @return
     */
    @Bean
    DirectExchange contractDirectExchange() {
        DirectExchange contractDirectExchange = new DirectExchange(QueueConstant.EXCHANGE_DIRECT);
        this.rabbitAdmin.declareExchange(contractDirectExchange);
        return contractDirectExchange;
    }
    
    /** 1、定义队列 ******************************************************************************************************************/
    @Bean
    Queue queueHello() {
        Queue queue = new Queue(QueueConstant.QUEUE_NOTIFY_HELLO, true);
        this.rabbitAdmin.declareQueue(queue);
        return queue;
    }
    
    /** 2、绑定交换机 ******************************************************************************************************************/
	@Bean
	Binding bindingExchangeEmail(Queue queueHello, FanoutExchange exchange) {
		Binding binding = BindingBuilder.bind(queueHello).to(exchange);
		rabbitAdmin.declareBinding(binding);
		return binding;
	}

}