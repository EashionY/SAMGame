package com.mistytech.user.service;

import com.mistytech.user.bean.User;

public interface UserService {

	User login(String userName,String password);
	
	
}
