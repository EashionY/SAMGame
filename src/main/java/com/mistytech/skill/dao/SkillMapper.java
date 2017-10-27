package com.mistytech.skill.dao;

import com.mistytech.skill.bean.Skill;

public interface SkillMapper {
	
    int deleteByPrimaryKey(Integer skillId);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(Integer skillId);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);
}