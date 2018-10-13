package com.async.boot;

import java.util.concurrent.Future;

public interface AsyncAfterService {
	
	/**  
	* @Title: asyncAfterOne  
	* @Description: TODO(修改方法一)  
	* @param @return
	* @param @throws InterruptedException    参数  
	* @return Future<String>    返回类型  
	* @throws  
	*/ 
	public Future<String> asyncAfterOne() throws InterruptedException;
	
	/**  
	* @Title: asyncAfterThree  
	* @Description: TODO(修改方法二)  
	* @param @return    参数  
	* @return Future<String>   返回类型  
	* @throws  
	*/ 
	public Future<String> asyncAfterTwo() throws InterruptedException;
	
	/**  
	* @Title: asyncAfterThree  
	* @Description: TODO(修改方法三)  
	* @param @throws InterruptedException    参数  
	* @return Future<String>    返回类型  
	* @throws  
	*/ 
	public Future<String> asyncAfterThree() throws InterruptedException;
}
