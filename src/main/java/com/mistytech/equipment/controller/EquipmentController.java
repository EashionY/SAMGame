package com.mistytech.equipment.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mistytech.base.BaseController;
import com.mistytech.equipment.bean.Equipment;
import com.mistytech.equipment.service.EquipmentService;
import com.mistytech.util.JsonWrapper;

import sun.misc.BASE64Decoder;

@Controller
@RequestMapping("/equipment")
public class EquipmentController extends BaseController{
	@Resource
	private EquipmentService service;
	
	/**
	 * 查询所有装备
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public HashMap<String, Object> findAll(){
		List<Equipment> eqs = service.findAll();
		return JsonWrapper.successWrapper(eqs);
	}
	/**
	 * 分页查询
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
	 * 保存装备
	 * @param request 参数：eqImg,defense,eqName,eqRare,resistance,resistanceType
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/saveEquipment")
	@ResponseBody
	public HashMap<String,Object> saveEquipment(Equipment equipment){
		try {
			String imgurl = equipment.getImgurl();
			BASE64Decoder decoder = new BASE64Decoder();
			// 解密
			byte[] b = decoder.decodeBuffer(imgurl);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			File file = new File("D:\\SAMUpload\\"+equipment.getEqName()+".gif");
			imgurl = file.getPath();
			OutputStream out = new FileOutputStream(imgurl);
			out.write(b);
			out.flush();
			out.close();
			equipment.setImgurl(imgurl);
			service.insert(equipment);
			return JsonWrapper.successWrapper("装备保存成功");
		} catch (Exception e1) {
			e1.printStackTrace();
			log.error(e1.getMessage(),e1);
			return JsonWrapper.failureWrapper("网络异常");
		}
	}
	
	/**
	 * 修改装备
	 * @param eq
	 * @return
	 */
	@RequestMapping("/updateEq")
	@ResponseBody
	public HashMap<String,Object> updateEquipment(Equipment eq){
		try {
			service.update(eq);
			return JsonWrapper.successWrapper("装备修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("网络异常");
		}
	}
	/**
	 * 删除装备
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteEq")
	@ResponseBody
	public HashMap<String,Object> deleteEquipment(Integer id){
		try {
			service.removeById(id);
			return JsonWrapper.successWrapper("装备修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return JsonWrapper.failureWrapper("网络异常");
		}
	}
}
