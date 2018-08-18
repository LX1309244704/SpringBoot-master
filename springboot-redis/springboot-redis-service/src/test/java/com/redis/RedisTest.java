package com.redis;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.redis.model.User;
import com.redis.service.RedisService;
import com.redis.util.JsonUtil;

@RunWith(SpringRunner.class)  
@SpringBootTest(classes = RedisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@EnableAutoConfiguration
public class RedisTest {
	
	@Autowired
	private RedisService redisService;

	@Test
	public void set() {
		
		List<User> list = new ArrayList<User>();
		
		User user = new User();
		user.setId("1");
		user.setAge(12);
		user.setName("张三");
		
		User user2 = new User();
		user2.setId("1");
		user2.setAge(12);
		user2.setName("张三");
		
		list.add(user);
		list.add(user2);
		
		redisService.set("1", user.toString());
		redisService.set("2", JsonUtil.toJson(list));
		List<User> list2=JsonUtil.toObjectList(User.class, redisService.get("2"));
		System.out.println(list2);
	}
	
	@Test
	public void del() {
		redisService.remove("2");
		System.out.println(redisService.get("2"));
	}
	
}
