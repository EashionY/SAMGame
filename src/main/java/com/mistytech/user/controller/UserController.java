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

import sun.security.provider.MD5;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource
	private IUserService userService;
	
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
			return JsonWrapper.successWrapper(user);
		} catch (Exception e) {
			this.log.error(e.getMessage());
			e.printStackTrace();
			return JsonWrapper.failureWrapper("网络异常");
		}
	}

}
