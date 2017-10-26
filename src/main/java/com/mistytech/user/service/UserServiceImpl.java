package com.mistytech.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mistytech.user.bean.User;
import com.mistytech.user.dao.UserMapper;
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;
	
	public User findByUserName(String username) {
		User user = userMapper.findByUsername(username);
		return user;
	}
	
	public void saveUser(User user) throws Exception{
		userMapper.insertSelective(user);
	}

	public void updateUser(User user) throws Exception{
		userMapper.updateByPrimaryKeySelective(user);
	}

	public User findByUserId(Integer userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

}
