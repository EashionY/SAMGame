package com.mistytech.user.service;

import com.mistytech.user.bean.User;

public interface IUserService {
	
	public User findByUserName(String username);
	
	public void saveUser(User user) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public User findByUserId(Integer userId);
	
}
