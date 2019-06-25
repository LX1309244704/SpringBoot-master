package com.kafka.producer.impl;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.api.HelloProducerService;

/** 
* @ClassName: HelloProducerServiceImpl 
* @Description: TODO(ProducerService实现方法) 
* @author lixin(1309244704@qq.com)
* @date 2019年2月15日 下午2:03:02 
*  
*/
@Service
public class HelloProducerServiceImpl implements HelloProducerService{
	
	private Logger logger = LoggerFactory.getLogger(HelloProducerServiceImpl.class);
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendSyncHello(String helloQueue, String message) throws InterruptedException, ExecutionException {
		logger.debug("发送同步信息");
		try {
			kafkaTemplate.send("app_log", message).get();
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("消费成功"+System.currentTimeMillis());
	}

	@Override
	public void sendAsyncHello(String helloQueue, String message) {
		logger.debug("发送回调异步信息");
    	ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("app_log1", message);
    	future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
            	try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            	logger.debug("消费成功"+System.currentTimeMillis());
            }
            @Override
            public void onFailure(Throwable ex) {
            	logger.debug("消费失败");
            	ex.getStackTrace();
            }
        });
	}

}
