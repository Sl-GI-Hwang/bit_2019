package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void CategorySelectTest() {
		System.out.println("[Category Select Test]");
		Boolean testc = false;
		CategoryDao dao = new CategoryDao();
		List <CategoryVo> result = new ArrayList<CategoryVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Select Complete]");
	}

	public static void CategoryListTest() {
		System.out.println("[Category Test]");
		Boolean[] testc = new Boolean[3];

		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("소설");
		testc[0] = dao.insert(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName("시");
		testc[1] = dao.insert(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setName("수필");
		testc[2] = dao.insert(vo3);
		
		if(testc[0] && testc[1] && testc[2]) {
			System.out.println(vo1.toString());
			System.out.println(vo2.toString());
			System.out.println(vo3.toString());
			
			System.out.println("[Insert Complete]");
		}
		
	}
}
