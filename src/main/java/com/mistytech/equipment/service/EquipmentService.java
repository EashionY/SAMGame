package com.mistytech.equipment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mistytech.base.BaseService;
import com.mistytech.equipment.bean.Equipment;
import com.mistytech.equipment.dao.EquipmentMapper;

@Service("equipmentService")
public class EquipmentService implements BaseService<Equipment> {
	@Resource
	private EquipmentMapper dao;

	public List<Equipment> findAll() {
		List<Equipment> eqs = dao.findAll();
		return eqs;
	}

	public List<Equipment> pageQuery(Integer page, Integer count) {
		Integer offset = (page - 1) * count;
		List<Equipment> eqs = dao.pageQuery(offset, count);
		return eqs;
	}

	public void update(Equipment entity) throws Exception {
		dao.insertSelective(entity);
	}

	public void removeById(Integer id) throws Exception{
		dao.deleteByPrimaryKey(id);
	}

	public void insert(Equipment entity) throws Exception{
		dao.insertSelective(entity);
	}

	public Equipment findById(Integer entityId) {
		Equipment equipment = dao.selectByPrimaryKey(entityId);
		return equipment;
	}

}
