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

@SuppressWarnings("restriction")
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
		String path = request.getSession().getServletContext().getRealPath(String.valueOf(File.separatorChar));
		path += "UploadImg" + File.separatorChar;
		File file = new File(path+System.currentTimeMillis()+".gif");
		if(!file.exists()) {
			file.getParentFile().mkdir();
		    file.createNewFile();
		}
		path = file.getPath();
		OutputStream out = new FileOutputStream(path);
		out.write(b);
		out.flush();
		out.close();
		equipment.setImgurl(path);
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
