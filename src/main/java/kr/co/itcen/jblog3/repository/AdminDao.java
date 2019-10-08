package kr.co.itcen.jblog3.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog3.vo.CategoryVo;
import kr.co.itcen.jblog3.vo.PostVo;

@Repository
public class AdminDao {
	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> getCategory(String id) {
		List<CategoryVo> categoryvo = sqlSession.selectList("categoryList", id);
		return categoryvo;
	}

	public void write(PostVo postVo) {
		sqlSession.update("writeBlog", postVo);
	}
	
	
}
