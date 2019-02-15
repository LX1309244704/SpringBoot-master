package com.kafka;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kafka.api.HelloProducerService;



/**
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)  
@SpringBootTest(classes = KafkaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@EnableAutoConfiguration
public class KafkaCase {
	
	@Autowired
    private HelloProducerService helloProducerService;
	
	@Test
	public void sendSyncTest() {
		for (int i = 0; i < 1; i++) {
			 String message = UUID.randomUUID().toString();
		     System.out.println("发送消息:"+i);
		     helloProducerService.sendSyncHello("app_log", message);
		     System.out.println("发送完成"+System.currentTimeMillis()+"ms");
		}
	}
	
	@Test
	public void sendAsyncTest() {
		for (int i = 0; i < 1; i++) {
			 String message = UUID.randomUUID().toString();
		     System.out.println("发送消息:"+i);
		     helloProducerService.sendAsyncHello("app_log1", message+0000+i);
		     System.out.println("发送完成"+System.currentTimeMillis()+"ms");
		}
	}
}
