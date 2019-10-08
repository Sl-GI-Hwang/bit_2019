package kr.co.itcen.jblog3.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlSession;

	public Map<String, Object> getAll(String id, long categoryNo, long postNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("blogInfo", sqlSession.selectOne("blogInfo", id));
		map.put("categoryList", sqlSession.selectList("categoryList", id));
		
		Map<String, Object> buff = new HashMap<String, Object>();
		buff.put("blogId", id);
		buff.put("categoryNo", categoryNo);
		buff.put("postNo", postNo);
		
		map.put("postList", sqlSession.selectList("postList", buff));
		map.put("postInfo", sqlSession.selectOne("postInfo", buff));
		
		return map;
	}
	
	
}
