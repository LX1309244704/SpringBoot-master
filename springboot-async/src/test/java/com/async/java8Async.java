package com.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class java8Async {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		// CompletableFuture.supplyAsync（），定义要执行的异步任务
		CompletableFuture<String> asyncResult = CompletableFuture.supplyAsync(new Supplier<String>() {

			@Override
			public String get() {
				// TODO Auto-generated method stub
				try {
					System.out.println("任务1");
					// 睡眠1s
					TimeUnit.SECONDS.sleep(1);
					System.out.println("任务2");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "返回数据async";
			}
		}, executor);

		// asyncResult.thenAccept(new Consumer<String>() ， 重写accept（）方法去定义回调函数
		asyncResult.thenAccept(new Consumer<String>() {
			public void accept(String arg0) {
				System.out.println("return =" + arg0);
			}
		});
		// return
		System.out.println("任务执行完成");
	}

}
