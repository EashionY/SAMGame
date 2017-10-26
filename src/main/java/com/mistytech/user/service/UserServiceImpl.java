package com.mistytech.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mistytech.user.bean.User;
import com.mistytech.user.dao.UserMapper;
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;
	
	public User findByUserName(String username){
		System.out.println(username);
		User user = userMapper.findByUsername(username);
		
		return user;
	}
	public void regist(User user) {

	}

	public void modifyPwd(Integer userId, String oldPwd, String newPwd) {

	}

}
