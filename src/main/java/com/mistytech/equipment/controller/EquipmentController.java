package com.mistytech.equipment.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mistytech.equipment.bean.Equipment;
import com.mistytech.equipment.service.EquipmentService;
import com.mistytech.util.JsonWrapper;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	@Resource
	private EquipmentService service;
	
	/**
	 * 查询所有装备
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public HashMap<String, Object> findAll(){
		List<Equipment> eqs = this.service.findAll();
		return JsonWrapper.successWrapper(eqs);
	}
	/**
	 * 分页查询
	 * @param page
	 * @param count
	 * @return
	 */
	@RequestMapping("/pageQuery")
	@ResponseBody
	public HashMap<String, Object> pageQuery(Integer page,Integer count){
		List<Equipment> eqs = this.service.pageQuery(page, count);
		return  JsonWrapper.successWrapper(eqs);
	}
}
