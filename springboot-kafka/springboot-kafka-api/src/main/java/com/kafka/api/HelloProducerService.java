package com.kafka.api;

import java.util.concurrent.ExecutionException;

/**
* @ClassName: HelloProducerService
* @Description: TODO(Producer接口)
* @author lixin(1309244704@qq.com)
* @date 2019年2月15日
* @version V1.0
*/
public interface HelloProducerService {
	
	/**
	 * @throws ExecutionException 
	 * @throws InterruptedException  
	* @Title: sendSyncHello 
	* @Description: TODO(同步发送) 
	* @param @param helloQueue
	* @param @param message  参数说明 
	* @return void    返回类型 
	* @throws 
	*/
	public void sendSyncHello(String helloQueue,String message) throws InterruptedException, ExecutionException;
	
	/** 
	* @Title: sendAsyncHello 
	* @Description: TODO(异步发送) 
	* @param @param helloQueue
	* @param @param message  参数说明 
	* @return void    返回类型 
	* @throws 
	*/
	public void sendAsyncHello(String helloQueue,String message);
	
}
