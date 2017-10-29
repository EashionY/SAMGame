package com.mistytech.skill.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mistytech.base.BaseController;
import com.mistytech.skill.bean.Skill;
import com.mistytech.skill.service.ISkillService;
import com.mistytech.util.JsonWrapper;
import com.mistytech.util.Upload;
@Controller
@RequestMapping("/skill")
public class SkillController extends BaseController {

	@Resource
	private ISkillService skillService;
	
	/**
	 * 添加技能
	 * 
	 * @param request 参数：damageDirect，skillImg，damageIndirect，skillIntro，skillName，skillRare，skillType
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/saveSkill", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> saveSkill(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		Skill skill = new Skill();
		skill.setDamageDirect(Integer.parseInt(request.getParameter("damageDirect")));
		List<String> path;
		try {
			path = Upload.uploadImg(request, "skillImg");
		} catch (IOException e1) {
			e1.printStackTrace();
			log.error(e1.getMessage(),e1);
			return JsonWrapper.failureWrapper("技能图标上传失败");
		}
		skill.setSkillImg(path.get(0));
		skill.setDamageIndirect(Integer.parseInt(request.getParameter("damageIndirect")));
		skill.setSkillIntro(request.getParameter("skillIntro"));
		skill.setSkillName(request.getParameter("skillName"));
		skill.setSkillRare(Integer.parseInt(request.getParameter("skillRare")));
		skill.setSkillType(Integer.parseInt(request.getParameter("skillType")));
		try {
			skillService.saveSkill(skill);
			return JsonWrapper.successWrapper("技能添加成功 ");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("网络异常");
		}
	}
	
	/**
	 * 查找全部技能
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public HashMap<String,Object> findAll(Integer page,Integer pageSize){
		List<Map<String,Object>> result = skillService.findAll(page, pageSize);
		return JsonWrapper.successWrapper(result);
	}
	
	/**
	 * 修改技能
	 * 
	 * @param skill
	 * @return
	 */
	@RequestMapping("/updateSkill")
	@ResponseBody
	public HashMap<String,Object> updateSkill(Skill skill){
		try {
			skillService.updateSkill(skill);
			return JsonWrapper.successWrapper("技能修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("网络异常");
		}
	}
	
	/**
	 * 删除技能
	 * 
	 * @param skillId
	 * @return
	 */
	@RequestMapping("/deleteSkill")
	@ResponseBody
	public HashMap<String,Object> deleteSkill(Integer skillId){
		try {
			skillService.deleteSkill(skillId);
			return JsonWrapper.successWrapper("技能删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("网络异常");
		}
	}
}
