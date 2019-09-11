package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void OrderSelectTest() {
		System.out.println("[Order Select Test]");
		Boolean testc = false;
		OrderDao dao = new OrderDao();
		List <OrderVo> result = new ArrayList<OrderVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Order Complete]");
	}

	public static void OrderListTest() {
		System.out.println("[OrderDao Test]");
		Boolean[] testc = new Boolean[2];

		OrderDao dao = new OrderDao();
		
		OrderVo vo1 = new OrderVo();
		vo1.setPrice(100000);
		vo1.setOrder_address("서울특별시 강변대로 22길");
		vo1.setMember_no(1);
		testc[0] = dao.insert(vo1);
		
		if(testc[0]) {
			System.out.println(vo1.toString());
			System.out.println("[Order Complete]");
		}
	}
}
