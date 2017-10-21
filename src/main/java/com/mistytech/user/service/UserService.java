package com.mistytech.user.service;

import com.mistytech.user.bean.User;

public interface UserService {

	User login(String userName,String password);
	
	void regist(User user);
	
	void modifyPwd(Integer userId,String oldPwd,String newPwd);
}
