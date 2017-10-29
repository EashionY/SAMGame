package com.mistytech.role.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mistytech.role.bean.Role;
import com.mistytech.role.dao.RoleMapper;
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Resource
	private RoleMapper roleMapper;
	
	public void createRole(Role role) throws Exception {
		roleMapper.insertSelective(role);
	}

	
}
