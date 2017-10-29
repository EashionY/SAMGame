package com.mistytech.skill.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mistytech.skill.bean.Skill;

public interface SkillMapper {
    int deleteByPrimaryKey(Integer skillId);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(Integer skillId);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);
    
    List<Map<String,Object>> findAll(@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
    
}