package com.mistytech.user.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mistytech.base.BaseController;
import com.mistytech.user.bean.User;
import com.mistytech.user.service.IUserService;
import com.mistytech.util.JsonWrapper;
import com.mistytech.util.Md5Util;
import com.mistytech.util.SessionUtils;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource
	private IUserService userService;
	
	/**
	 * 登录.
	 *
	 * @param request the request
	 * @param username the username
	 * @param password the password
	 * @return the hash map
	 */
	@RequestMapping("/login")
	@ResponseBody
	public HashMap<String, Object> login(HttpServletRequest request, String username, String password) {
		try {
			User user = userService.findByUserName(username);
			if (user == null) {
				return JsonWrapper.failureWrapper("用户名或密码错误");
			}
			String pwd = user.getPassword();
			password = Md5Util.MD5(password);
			if(!pwd.equals(password)) {
				return JsonWrapper.failureWrapper("用户名或密码错误");
			}
			SessionUtils.setUser(request, user);
			return JsonWrapper.successWrapper("登录成功");
		} catch (Exception e) {
			this.log.error(e.getMessage(),e);
			e.printStackTrace();
			return JsonWrapper.failureWrapper("网络异常");
		}
	}
	
	/**
	 * 注册.
	 *
	 * @param user the user
	 * @return the hash map
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public HashMap<String, Object> regist(User user){
		String username = user.getUsername();
		User user1 = userService.findByUserName(username);
		if(user1 != null) {
			return JsonWrapper.failureWrapper("用户名已存在");
		}else {
			try {
				String pwd = user.getPassword();
				user.setPassword(Md5Util.MD5(pwd));
				userService.saveUser(user);
				return JsonWrapper.successWrapper("注册成功");
			} catch (Exception e) {
				e.printStackTrace();
				this.log.error(e.getMessage(),e);
				return JsonWrapper.failureWrapper("网络异常");
			}
		}
	}
	
	/**
	 * 修改密码.
	 *
	 * @param userId the user id
	 * @param oldPwd the old pwd
	 * @param newPwd the new pwd
	 * @return the hash map
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public HashMap<String, Object> updatePwd(Integer userId,String oldPwd,String newPwd){
		User user = userService.findByUserId(userId);
		if(user == null) {
			return JsonWrapper.failureWrapper("账号不存在");
		}
		oldPwd = Md5Util.MD5(oldPwd);
		if(!oldPwd.equals(user.getPassword())) {
			return JsonWrapper.failureWrapper("旧密码错误");
		}
		newPwd = Md5Util.MD5(newPwd);
		user.setPassword(newPwd);
		try {
			userService.updateUser(user);
			return  JsonWrapper.successWrapper("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("网络异常");
		}
	}

}
