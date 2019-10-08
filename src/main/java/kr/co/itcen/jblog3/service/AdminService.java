package kr.co.itcen.jblog3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
}
