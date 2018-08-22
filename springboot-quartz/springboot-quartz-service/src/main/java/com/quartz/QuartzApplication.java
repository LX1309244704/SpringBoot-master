package com.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.quartz.mapper")
public class QuartzApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuartzApplication.class, args);
	}
}
