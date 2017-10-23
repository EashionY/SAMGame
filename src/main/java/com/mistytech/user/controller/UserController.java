package com.mistytech.user.controller;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mistytech.user.service.UserService;
import com.mistytech.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	@RespectBinding
	public JsonResult login(String userName,String password) {
		return new JsonResult(userService.login(userName, password));
	}
	
}
