package kr.co.itcen.jblog3.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import kr.co.itcen.jblog3.repository.AdminDao;
import kr.co.itcen.jblog3.vo.CategoryVo;
import kr.co.itcen.jblog3.vo.PostVo;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public List<CategoryVo> getCategory(String id) {
		return adminDao.getCategory(id);
	}

	public void write(PostVo postVo) {
		adminDao.write(postVo);
	}

	public ModelMap editCategory(String id) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAllAttributes(adminDao.editCategory(id));
		return modelMap;
	}

	public Boolean delete(CategoryVo categoryVo) {
		return adminDao.delete(categoryVo) == 1;
	}

	public Map<String, Object> insert(CategoryVo categoryVo) {
		Map<String, Object> map = adminDao.insert(categoryVo);
		return map;
	}
	
}
