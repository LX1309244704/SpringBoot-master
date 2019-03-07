package com.rabbitmq.api;

public interface IAmqpHelloService {
	public void receiveHelloQueue(String message); 
}
