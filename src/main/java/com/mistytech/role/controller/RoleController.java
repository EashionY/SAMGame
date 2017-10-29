package com.mistytech.role.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mistytech.base.BaseController;
import com.mistytech.role.bean.Role;
import com.mistytech.role.service.IRoleService;
import com.mistytech.util.JsonWrapper;
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{

	@Resource
	private IRoleService roleService;
	
	/**
	 * ������ɫ
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping("/createRole")
	@ResponseBody
	public HashMap<String,Object> createRole(Role role){
		try {
			roleService.createRole(role);
			return JsonWrapper.successWrapper("��ɫ�����ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("�����쳣");
		}
	}
	
}
