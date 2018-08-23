package com.dubbo.api;

import com.dubbo.domain.User;

public interface UserService {
	
	public User getUser(String id);
	
	public void deleteUser(String id);

}
