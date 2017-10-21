package com.mistytech.user.service;

import org.springframework.stereotype.Service;

import com.mistytech.user.bean.User;
@Service("userService")
public class UserServiceImpl implements UserService{

	public User login(String userName, String password) {
		
		return null;
	}

	public void regist(User user) {
		
	}

	public void modifyPwd(Integer userId, String oldPwd, String newPwd) {
		
	}

}
