package com.mistytech.equipment.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mistytech.base.BaseController;
import com.mistytech.equipment.bean.Equipment;
import com.mistytech.equipment.service.EquipmentService;
import com.mistytech.util.JsonWrapper;
import com.mistytech.util.Upload;

@Controller
@RequestMapping("/equipment")
public class EquipmentController extends BaseController{
	@Resource
	private EquipmentService service;
	
	/**
	 * ��ѯ����װ��
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public HashMap<String, Object> findAll(){
		List<Equipment> eqs = service.findAll();
		return JsonWrapper.successWrapper(eqs);
	}
	/**
	 * ��ҳ��ѯ
	 * @param page
	 * @param count
	 * @return
	 */
	@RequestMapping("/pageQuery")
	@ResponseBody
	public HashMap<String, Object> pageQuery(Integer page,Integer count){
		List<Equipment> eqs = service.pageQuery(page, count);
		return  JsonWrapper.successWrapper(eqs);
	}
	/**
	 * ����װ��
	 * @param request ������eqImg,defense,eqName,eqRare,resistance,resistanceType
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/saveEquipment")
	@ResponseBody
	public HashMap<String,Object> saveEquipment(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		List<String> path;
		try {
			path = Upload.uploadImg(request, "eqImg");
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("װ��ͼ���ϴ�ʧ��");
		}
		Equipment eq = new Equipment();
		eq.setImgurl(path.get(0));
		eq.setDefense(request.getParameter("defense"));
		eq.setEqName(request.getParameter("eqName"));
		eq.setEqRare(Integer.parseInt(request.getParameter("eqRare")));
		eq.setResistance(request.getParameter("resistance"));
		eq.setResistanceType(Integer.parseInt(request.getParameter("resistanceType")));
		try {
			service.insert(eq);
			return JsonWrapper.successWrapper("װ������ɹ�");
		} catch (Exception e1) {
			e1.printStackTrace();
			log.error(e1.getMessage(),e1);
			return JsonWrapper.failureWrapper("�����쳣");
		}
	}
	
	/**
	 * �޸�װ��
	 * @param eq
	 * @return
	 */
	@RequestMapping("/updateEq")
	@ResponseBody
	public HashMap<String,Object> updateEquipment(Equipment eq){
		try {
			service.update(eq);
			return JsonWrapper.successWrapper("װ���޸ĳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("�����쳣");
		}
	}
	/**
	 * ɾ��װ��
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteEq")
	@ResponseBody
	public HashMap<String,Object> deleteEquipment(Integer id){
		try {
			service.removeById(id);
			return JsonWrapper.successWrapper("װ���޸ĳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("�����쳣");
		}
	}
}
