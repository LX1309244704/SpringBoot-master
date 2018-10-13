package com.async.boot;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**  
* @ClassName: AsyncServiceImpl  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年10月13日 下午4:54:15  
* @version V1.0  
*/ 
@Service
public class AsyncServiceImpl implements AsyncService{
	
	@Autowired
	private AsyncAfterService asyncAfterService;
	
	
	@Transactional
	@Override
	public String asyncOne() throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		asyncAfterService.asyncAfterOne();
		asyncAfterService.asyncAfterTwo();
		asyncAfterService.asyncAfterThree();
		long currentTimeMillis1 = System.currentTimeMillis();
		return "asyncAfter任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";
	}
	
	@Transactional
	@Override
	public String asyncTwo() throws InterruptedException, ExecutionException {
		long currentTimeMillis = System.currentTimeMillis();
		Future<String> two = asyncAfterService.asyncAfterTwo();
		Future<String> three = asyncAfterService.asyncAfterThree();
		String result = null;
		while (true) {
			if(two.isDone() && three.isDone()) {
				System.err.println(two.get());
				System.err.println(three.get());
				// 两个任务都调用完成，跳出循环
				break;
			}
			Thread.sleep(1000);
		}
		long currentTimeMillis1 = System.currentTimeMillis();
		result = "asyncAfter任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";
		return result;
	}
	
}
