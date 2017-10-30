package com.mistytech.equipment.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mistytech.base.BaseService;
import com.mistytech.equipment.bean.Equipment;
import com.mistytech.equipment.dao.EquipmentMapper;

import sun.misc.BASE64Decoder;

@Service("equipmentService")
public class EquipmentService implements BaseService<Equipment> {
	@Resource
	private EquipmentMapper dao;

	public List<Equipment> findAll() {
		List<Equipment> eqs = dao.findAll();
		return eqs;
	}

	public List<Equipment> pageQuery(Integer page, Integer count) {
		Integer offset = (page - 1) * count;
		List<Equipment> eqs = dao.pageQuery(offset, count);
		return eqs;
	}

	public void update(Equipment entity) throws Exception {
		dao.updateByPrimaryKeySelective(entity);
	}

	public void removeById(Integer id) throws Exception{
		dao.deleteByPrimaryKey(id);
	}

	public void insert(HttpServletRequest request,Equipment equipment) throws Exception{
		String imgurl = equipment.getImgurl();
		BASE64Decoder decoder = new BASE64Decoder();
		// 解密
		byte[] b = decoder.decodeBuffer(imgurl);
		for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {
				b[i] += 256;
			}
		}
		String os = System.getProperty("os.name");
		String path;
		if(os.toLowerCase().startsWith("win")){
			path = "D:\\SAMUpload"+File.separatorChar;
		}else {
			path = "/usr/SAMUpload/";
		}
		String relPath = "UploadImg" + File.separatorChar;
		path += relPath;
		String imgName = equipment.getEqName()+".gif";
		path += imgName;
		imgurl = relPath + imgName;
		File file = new File(path);
		if(!file.exists()) {
			file.getParentFile().mkdir();
		    file.createNewFile();
		}
		OutputStream out = new FileOutputStream(path);
		out.write(b);
		out.flush();
		out.close();
		imgurl = "img"+File.separatorChar+imgurl;
		equipment.setImgurl(imgurl);
		dao.insertSelective(equipment);
	}

	public Equipment findById(Integer entityId) {
		Equipment equipment = dao.selectByPrimaryKey(entityId);
		return equipment;
	}

	public void insert(Equipment entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
