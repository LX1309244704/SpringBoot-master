package com.rabbitmq.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.api.IAmqpHelloService;

@Component
public class AmqpServiceConsumer {
	 private Logger logger = LoggerFactory.getLogger(AmqpServiceConsumer.class);
	    @Autowired
	    private IAmqpHelloService amqpHelloService;

	    public AmqpServiceConsumer() {
	    }

	    @RabbitListener(queues = {"com.queue.notify.hello"})
	    public void receiveSmsCodeQueue(String message) {
	        this.logger.info("------hello：消费者处理消息------");
	        this.logger.debug(message);
	        this.amqpHelloService.receiveHelloQueue(message);
	    }
}
