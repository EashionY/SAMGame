package com.mistytech.skill.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mistytech.skill.bean.Skill;
import com.mistytech.skill.dao.SkillMapper;
@Service("skillService")
public class SkillServiceImpl implements ISkillService {

	@Resource
	private SkillMapper skillMapper;
	
	public List findAll(Integer page, Integer pageSize) {
		
		return null;
	}

	public void saveSkill(Skill skill) throws Exception{
		skillMapper.insertSelective(skill);
	}

}
