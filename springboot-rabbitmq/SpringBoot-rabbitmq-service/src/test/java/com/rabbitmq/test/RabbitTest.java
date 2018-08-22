package com.rabbitmq.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.RabbitApplication;
import com.rabbitmq.api.IAmqpService;

@RunWith(SpringRunner.class)  
@SpringBootTest(classes = RabbitApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class RabbitTest {
	
	@Autowired
	private IAmqpService amqpService;

	@Test
	public void test() {
		String message = "Hello测试信息";
		amqpService.convertAndSend(message);
	}
}
