package com.dubbo.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.UserService;
import com.dubbo.domain.User;


@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String id) {
		User user = new User();
		user.setId(id);
		user.setName("香菇");
		user.setAge(18);
		return user;
	}

	@Override
	public void deleteUser(String id) {
		System.out.println(id+"进入实现类删除数据！");
	}

}
