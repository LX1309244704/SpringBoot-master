package com.async;


import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.async.boot.AsyncService;


@RunWith(SpringRunner.class)  
@SpringBootTest(classes = OtherApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class AsyncTest {
	
	@Autowired
	private AsyncService asyncService;

	
	@Test
	public void asyncOne() throws InterruptedException {
		System.err.println(asyncService.asyncOne());
		Thread.sleep(8000);
	}
	
	@Test
	public void asyncTwo() throws InterruptedException, ExecutionException {
		System.err.println(asyncService.asyncTwo());
	}
	
}
