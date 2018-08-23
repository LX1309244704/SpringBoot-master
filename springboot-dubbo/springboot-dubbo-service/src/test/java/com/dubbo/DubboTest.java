package com.dubbo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.UserService;
import com.dubbo.domain.User;

@RunWith(SpringRunner.class)  
@SpringBootTest(classes = DubboApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@EnableAutoConfiguration
public class DubboTest {
	
	@Reference
	private UserService userService;

	@Test
	public void getUser() {
		User user = userService.getUser("1");
		System.out.println(user);
	}
	
}
