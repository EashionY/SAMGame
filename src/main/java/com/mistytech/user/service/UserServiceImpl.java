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
			System.out.println("�û�������");
		}
		if (!password.equals(user.getPassword())) {
			System.out.println("�������");
		}
		return user;
	}

	public void regist(User user) {

	}

	public void modifyPwd(Integer userId, String oldPwd, String newPwd) {

	}

}
