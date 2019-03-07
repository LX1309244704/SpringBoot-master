package com.swagger.api;

import java.util.List;

import com.swagger.model.UserModel;

/**
 * <p> 服务接口</p>
 * @author lixin(1309244704@qq.com)
 * @since 2018-08-03
 */
public interface IUserService {
	
	/**  
	* @Title: getUser  
	* @Description: TODO(查询)  
	* @param @return    参数  
	* @return List<UserModel>    返回类型  
	* @throws  
	*/ 
	public List<UserModel> getUser();
	
	/**  
	* @Title: addUser  
	* @Description: TODO(添加)  
	* @param @param model    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void addUser(UserModel model);
	
}
