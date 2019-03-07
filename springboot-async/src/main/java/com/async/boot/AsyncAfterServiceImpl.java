package com.async.boot;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**  
* @ClassName: AsyncAfterServiceImpl  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年10月13日 下午4:50:38  
* @version V1.0  
*/ 

@Service
public class AsyncAfterServiceImpl implements AsyncAfterService{
	
	@Transactional
	@Override
	@Async
	public Future<String>  asyncAfterOne() throws InterruptedException {
		System.err.println("asyncAfterOne任务以执行");
		return new AsyncResult<String>("asyncAfterOne执行完毕");
	}
	
	@Transactional
	@Override
	@Async
	public Future<String> asyncAfterTwo() throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		Thread.sleep(3000);
		long currentTimeMillis1 = System.currentTimeMillis();
		System.err.println("asyncAfterTwo任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
		return new AsyncResult<String>("asyncAfterTwo执行完毕");
	}

	@Transactional
	@Override
	@Async
	public Future<String> asyncAfterThree() throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		Thread.sleep(6000);
		long currentTimeMillis1 = System.currentTimeMillis();
		System.err.println("asyncAfterThree任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
		return new AsyncResult<String>("asyncAfterThree执行完毕");
	}
	
}
