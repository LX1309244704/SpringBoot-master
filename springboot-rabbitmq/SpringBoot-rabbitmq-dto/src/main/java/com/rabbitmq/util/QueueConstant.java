package com.rabbitmq.util;

public interface QueueConstant {
		
	/**
	 * 类型
	 */
	String EXCHANGE_FANOUT 			= "com.exchange.fanout"; // 不处理路由键
	String EXCHANGE_TOPIC 			= "com.exchange.topic"; // 主题路由键
	String EXCHANGE_DIRECT			= "com.exchange.direct"; // 处理路由键
	
	/**
	 * 队列
	 */
	String QUEUE_NOTIFY_HELLO		= "com.queue.notify.hello"; // 定义的hello通知队列
}
