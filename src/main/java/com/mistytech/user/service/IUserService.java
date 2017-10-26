package com.mistytech.user.service;

import com.mistytech.user.bean.User;

public interface IUserService {

	public User login(String username,String password);
	
	public void regist(User user);
	
	public void modifyPwd(Integer userId,String oldPwd,String newPwd);
	
}
