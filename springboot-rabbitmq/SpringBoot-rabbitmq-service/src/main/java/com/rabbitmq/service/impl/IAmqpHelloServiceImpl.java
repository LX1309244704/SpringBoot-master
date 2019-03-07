package com.rabbitmq.service.impl;

import org.springframework.stereotype.Service;

import com.rabbitmq.api.IAmqpHelloService;

@Service
public class IAmqpHelloServiceImpl implements IAmqpHelloService{

	@Override
	public void receiveHelloQueue(String message) {
			System.out.println("IAmqpHelloServiceImpl---业务实现类"+message);
	}

}
