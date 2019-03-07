package com.swagger.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色
 * </p>
 * 
 * @author lixin(1309244704@qq.com)
 * @since 2018-08-03
 */
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "id", required = false, position = 1, example = "10001")
	private Long userId;
	
	@ApiModelProperty(value = "编号", required = false, position = 1, example = "10001")
	private String userCode;
	
	@ApiModelProperty(value = "名称", required = false, position = 1, example = "张三")
	private String userName;
	
	public UserModel() {
		
	}
	
	public UserModel(long userId, String userCode,String userName) {
		this.setUserId(userId);
		this.setUserCode(userCode);
		this.setUserName(userName);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userCode=" + userCode + ", userName=" + userName + "]";
	}

}
