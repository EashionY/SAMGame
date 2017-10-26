package com.mistytech.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mistytech.user.bean.User;
import com.mistytech.user.dao.UserMapper;
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;

	public User login(String username, String password) {
		User user = userMapper.findByUsername(username);
		if (user == null) {
			System.out.println("用户不存在");
		}
		if (!password.equals(user.getPassword())) {
			System.out.println("密码错误");
		}
		return user;
	}

	public void regist(User user) {

	}

	public void modifyPwd(Integer userId, String oldPwd, String newPwd) {

	}

}
