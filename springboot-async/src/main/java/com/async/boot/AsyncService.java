package com.async.boot;

import java.util.concurrent.ExecutionException;

public interface AsyncService {
	
	/**
	 * @throws InterruptedException   
	* @Title: asyncOne  
	* @Description: TODO(方法一)  
	* @param @return    参数  
	* @return String    返回类型  
	* @throws  
	*/ 
	public String asyncOne() throws InterruptedException;
	
	/**
	 * @throws ExecutionException   
	* @Title: asyncTwo  
	* @Description: TODO(方法二)  
	* @param @return    参数  
	* @return String    返回类型  
	* @throws  
	*/ 
	public String asyncTwo() throws InterruptedException, ExecutionException;
	
}
