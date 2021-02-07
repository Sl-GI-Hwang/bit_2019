package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void CartSelectTest() {
		System.out.println("[Cart Select Test]");
		Boolean testc = false;
		CartDao dao = new CartDao();
		List <CartVo> result = new ArrayList<CartVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Cart Complete]");
	}

	public static void CartListTest() {
		// TODO Auto-generated method stub
		System.out.println("[CartDao Test]");
		Boolean[] testc = new Boolean[2];

		CartDao dao = new CartDao();
		
		CartVo vo1 = new CartVo();
		vo1.setMember_no(1);
		vo1.setBook_no(1);
		vo1.setQuantity(200);
		testc[0] = dao.insert(vo1);
		
		CartVo vo2 = new CartVo();
		vo2.setMember_no(2);
		vo2.setBook_no(2);
		vo2.setQuantity(15);
		testc[1] = dao.insert(vo2);
		
		if(testc[0] && testc[1]) {
			System.out.println(vo1.toString());
			System.out.println(vo2.toString());
			
			System.out.println("[Insert Complete]");
		}
	}

}
