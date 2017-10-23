package com.mistytech.user.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mistytech.user.service.UserService;
import com.mistytech.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(String username,String password) {
		return new JsonResult(userService.login(username, password));
	}
	
}
