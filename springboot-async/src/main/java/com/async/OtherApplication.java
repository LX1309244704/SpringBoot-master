package com.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
* @ClassName: OtherApplication  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年10月13日 下午4:43:35  
* @version V1.0  
*/ 
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class OtherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtherApplication.class, args);
	}
}
