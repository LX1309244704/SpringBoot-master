package com.redis;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
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
	
	@Autowired
	private StringRedisTemplate template;
	
	@Test
	public void rightPopAndLeftPush() {
	ListOperations<String, String> operations =  this.template.opsForList();
	System.out.println(operations.leftPush("left","left1"));//1		
	System.out.println(operations.leftPush("left","left2"));//2		
	System.out.println(operations.leftPush("left","left3"));//3	
	System.out.println(operations.rightPush("right", "right1"));//1		
	System.out.println(operations.rightPush("right", "right2"));//2		
	System.out.println(operations.rightPush("right", "right3"));//3		
	System.out.println(operations.rightPopAndLeftPush("left", "right"));	
	}
	@Test
	public void leftPushAll() {
		List<User> list = new ArrayList<User>();

		User user = new User();
		user.setId("1");
		user.setAge(11);
		user.setName("张三1");
		
		User user1 = new User();
		user1.setId("2");
		user1.setAge(12);
		user1.setName("张三2");
		
		User user2 = new User();
		user2.setId("3");
		user2.setAge(13);
		user2.setName("张三3");
		
		list.add(user);
		list.add(user1);
		list.add(user2);
		String[] strings =new String[list.size()]; 
		for (int i = 0; i < list.size(); i++) {
			strings[i]=list.get(i).toString();
		}
		System.out.println(JsonUtil.toJson(strings));
		ListOperations<String, String> operations =  this.template.opsForList();
			operations.leftPushAll("users",strings);
			operations.leftPushAll("users1", JsonUtil.toJson(user),JsonUtil.toJson(user1),JsonUtil.toJson(user2));
			List<User> list2=JsonUtil.toObjectList(User.class, redisService.get("users"));
			System.out.println(list2);
			System.out.println(operations.size("users"));
	}
	
	@Test
	public void remove() {
		ListOperations<String, String> operations =  this.template.opsForList();
		for (int j = 0; j < 3; j++) {
			Long num = operations.leftPush("ceshi", String.valueOf(j));
			System.out.println("num:"+num);
		}
		operations.remove("ceshi", 2, "0");
		System.out.println(operations.range("ceshi", 0, -1));
		System.out.println(operations.size("ceshi"));
	}
	
	@Test
	public void leftPush() {
		
		ListOperations<String, String> operations =  this.template.opsForList();
		for (int j = 0; j < 3; j++) {
			Long num = operations.leftPush("ceshi", String.valueOf(j));
			System.out.println("num:"+num);
		}
		System.out.println(operations.range("ceshi", 0, -1));
		System.out.println(operations.size("ceshi"));
	}
	
	@Test
	public void set() {
		List<User> list = new ArrayList<User>();
		
		User user = new User();
		user.setId("1");
		user.setAge(12);
		user.setName("张三1");
		
		User user2 = new User();
		user2.setId("2");
		user2.setAge(12);
		user2.setName("张三2");
		
		list.add(user);
		list.add(user2);
		
		redisService.set("wangwu", JsonUtil.toJson(user));
		redisService.set("zhangsan123", JsonUtil.toJson(list));
		User get = JsonUtil.toObject(redisService.get("wangwu"), User.class);
		List<User> list2=JsonUtil.toObjectList(User.class, redisService.get("zhangsan123"));
		System.out.println(get);
		System.out.println(list2);
	}
	
	@Test
	public void del() {
		redisService.remove("2");
		System.out.println(redisService.get("2"));
	}
}
