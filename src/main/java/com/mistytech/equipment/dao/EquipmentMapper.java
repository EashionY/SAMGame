package com.mistytech.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mistytech.equipment.bean.Equipment;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
    
    List<Equipment> findAll();
    
    List<Equipment> pageQuery(@Param("offset")Integer offset, @Param("pageSize")Integer pageSize);
}