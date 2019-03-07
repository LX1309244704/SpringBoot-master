package com.swagger.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.swagger.api.IUserService;
import com.swagger.model.UserModel;


/**
 * @author lixin(1309244704@qq.com)
 * @since 2018-08-03
 */
@Service
public class UserServiceImpl implements IUserService {

	@Override
	public List<UserModel> getUser() {
		List<UserModel> list = new ArrayList<UserModel>();
		list.add(0, new UserModel(1L,"10001","张三"));
		list.add(1, new UserModel(2L,"10002","李四"));
		list.add(2, new UserModel(3L,"10003","王五"));
		list.add(3, new UserModel(4L,"10004","赵六"));
		return list;
	}

	@Override
	public void addUser(UserModel model) {
		System.out.println("进入添加方法"+model);
	}
	
}
