package com.mistytech.skill.service;

import java.util.List;
import java.util.Map;

import com.mistytech.skill.bean.Skill;

public interface ISkillService {

	public List<Map<String,Object>> findAll(Integer page,Integer pageSize);
	
	public void saveSkill(Skill skill) throws Exception;
	
	public void updateSkill(Skill skill) throws Exception;
	
	public void deleteSkill(Integer skillId) throws Exception;
	
}
