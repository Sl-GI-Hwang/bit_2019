package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {
	public static void OrderBookSelectTest() {
		System.out.println("[OrderBook Select Test]");
		Boolean testc = false;
		OrderBookDao dao = new OrderBookDao();
		List <OrderBookVo> result = new ArrayList<OrderBookVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[OrderBook Complete]");
	}

	public static void OrderBookListTest() {
		System.out.println("[OrderBook Test]");
		Boolean[] testc = new Boolean[2];

		OrderBookDao dao = new OrderBookDao();
		
		OrderBookVo vo1 = new OrderBookVo();
		vo1.setNo(1);
		vo1.setNo2(1);
		testc[0] = dao.insert(vo1);
		
		OrderBookVo vo2 = new OrderBookVo();
		vo2.setNo(2);
		vo2.setNo2(1);
		testc[1] = dao.insert(vo2);
		
		if(testc[0] && testc[1]) {
			System.out.println(vo1.toString());
			System.out.println(vo2.toString());
			System.out.println("[OrderBookDao Complete]");
		}
	}
}
