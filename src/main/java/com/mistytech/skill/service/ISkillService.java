package com.mistytech.skill.service;

import java.util.List;

import com.mistytech.skill.bean.Skill;

public interface ISkillService {

	public List findAll(Integer page,Integer pageSize);
	
	public void saveSkill(Skill skill) throws Exception;
	
}
