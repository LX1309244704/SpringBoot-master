package com.swagger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 
* @ClassName: SwaggerCommandLineRunner 
* @Description: TODO(启动加载swagger) 
* @author lixin
* @date 2018年8月17日 下午4:17:32 
*  
*/
@Component
@Order(value = 1)
public class SwaggerCommandLineRunner implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(SwaggerCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		logger.debug(">>>>>>>>>>>>>>服务启动加载:swagger初始化<<<<<<<<<<<<<");
	}

}
