package com.swagger.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swagger.api.IUserService;
import com.swagger.model.UserModel;
import com.swagger.util.ApiConst;
import com.swagger.util.ResultEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 角色前端控制器
 * </p>
 *
 * @author lixin(1309244704@qq.com)
 * @since 2018-08-03
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private @Autowired IUserService userService;

	@ApiOperation(value = "添加")
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResultEntity<String> addUser(
			@ApiParam(value = "id", required = true) @RequestParam(value = "userId", required = true) Long userId,
			@ApiParam(value = "角色编号", required = true) @RequestParam(value = "userCode", required = true) String userCode,
			@ApiParam(value = "角色名称", required = true) @RequestParam(value = "userName", required = true) String userName) {
		try {
			UserModel user = new UserModel();
			user.setUserId(Long.valueOf(userId));
			user.setUserCode(userCode);
			user.setUserName(userName);
			userService.addUser(user);
			return new ResultEntity<String>(ApiConst.CODE_SUCC, ApiConst.DESC_SUCC);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return new ResultEntity<String>(ApiConst.CODE_FAIL, ApiConst.DESC_FAIL);
	}
	@ApiOperation(value = "查询")
	@RequestMapping(value = "/getUser", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResultEntity<List<UserModel>> getUser() {
		try {
			List<UserModel> list = userService.getUser();
			return new ResultEntity<List<UserModel>>(ApiConst.CODE_SUCC, ApiConst.DESC_SUCC,list);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return new ResultEntity<List<UserModel>>(ApiConst.CODE_FAIL, ApiConst.DESC_FAIL);
	}
	
}
