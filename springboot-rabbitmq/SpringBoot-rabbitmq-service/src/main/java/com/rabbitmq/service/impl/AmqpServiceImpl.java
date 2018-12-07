package com.rabbitmq.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.api.IAmqpService;
import com.rabbitmq.util.QueueConstant;

@Service
public class AmqpServiceImpl implements IAmqpService {
	
	private @Autowired AmqpTemplate amqpTemplate;

	@Override
	public void convertAndSend(String message) {
		amqpTemplate.convertAndSend(QueueConstant.QUEUE_NOTIFY_HELLO, message);
	}

}
