package com.mistytech.skill.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mistytech.skill.bean.Skill;
import com.mistytech.skill.dao.SkillMapper;

@Service("skillService")
public class SkillServiceImpl implements ISkillService {

	@Resource
	private SkillMapper skillMapper;

	public List<Map<String, Object>> findAll(Integer page, Integer pageSize) {
		Integer offset = null;
		if(page != null) {
			offset = (page - 1) * pageSize;
		}
		return skillMapper.findAll(offset, pageSize);
	}

	public void saveSkill(Skill skill) throws Exception {
		skillMapper.insertSelective(skill);
	}

	public void updateSkill(Skill skill) throws Exception {
		skillMapper.updateByPrimaryKeySelective(skill);
	}

	public void deleteSkill(Integer skillId) throws Exception {
		skillMapper.deleteByPrimaryKey(skillId);
	}

}
