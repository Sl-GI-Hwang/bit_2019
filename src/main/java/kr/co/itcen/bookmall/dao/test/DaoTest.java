package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.*;
import kr.co.itcen.bookmall.vo.*;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberListTest();
		MemberSelectTest();
		
		CategoryListTest();
		CategorySelectTest();
		
		BookListTest();
		BookSelectTest();
		
		CartListTest();
		CartSelectTest();
		
		OrderListTest();
		OrderSelectTest();
		
		// Join 구현
		OrderBookListTest();
		OrderBookSelectTest();
		
		// 초기화
		DeleteAll();
	}

	private static void DeleteAll() {
		System.out.println("[Delete All]");
		Boolean[] testc = new Boolean[2];

		DeleteDao dao = new DeleteDao();
		
		testc[0] = dao.delete();
		
		
		if(testc[0]) {
			System.out.println("[Delete Complete]");
		}
		
	}

	private static void OrderBookSelectTest() {
		System.out.println("[OrderBook Select Test]");
		Boolean testc = false;
		OrderBookDao dao = new OrderBookDao();
		List <OrderBookVo> result = new ArrayList<OrderBookVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[OrderBook Complete]");
	}

	private static void OrderBookListTest() {
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

	private static void OrderSelectTest() {
		System.out.println("[Order Select Test]");
		Boolean testc = false;
		OrderDao dao = new OrderDao();
		List <OrderVo> result = new ArrayList<OrderVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Order Complete]");
	}

	private static void OrderListTest() {
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

	private static void CartSelectTest() {
		System.out.println("[Cart Select Test]");
		Boolean testc = false;
		CartDao dao = new CartDao();
		List <CartVo> result = new ArrayList<CartVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Cart Complete]");
	}

	private static void CartListTest() {
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

	private static void BookSelectTest() {
		System.out.println("[Book Select Test]");
		Boolean testc = false;
		BookDao dao = new BookDao();
		List <BookVo> result = new ArrayList<BookVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Select Complete]");
	}

	private static void BookListTest() {
		System.out.println("[BookDao Test]");
		Boolean[] testc = new Boolean[3];

		BookDao dao = new BookDao();
		
		BookVo vo1 = new BookVo();
		vo1.setName("아프리카 청춘이다");
		vo1.setPrice(100);
		vo1.setCategory_no(1);
		testc[0] = dao.insert(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setName("정의란 무엇인가");
		vo2.setPrice(100000);
		vo2.setCategory_no(3);
		testc[1] = dao.insert(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setName("비행기");
		vo3.setPrice(14000);
		vo3.setCategory_no(2);
		testc[2] = dao.insert(vo3);
		
		if(testc[0] && testc[1] && testc[2]) {
			System.out.println(vo1.toString());
			System.out.println(vo2.toString());
			System.out.println(vo3.toString());
			
			System.out.println("[Insert Complete]");
		}
	}

	private static void CategorySelectTest() {
		System.out.println("[Category Select Test]");
		Boolean testc = false;
		CategoryDao dao = new CategoryDao();
		List <CategoryVo> result = new ArrayList<CategoryVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Select Complete]");
	}

	private static void CategoryListTest() {
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

	private static void MemberSelectTest() {
		System.out.println("[Member Select Test]");
		Boolean testc = false;
		MemberDao dao = new MemberDao();
		List <MemberVo> result = new ArrayList<MemberVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Select Complete]");
		
	}

	private static void MemberListTest() {
		System.out.println("[Member Test]");
		Boolean[] testc = new Boolean[2];

		MemberDao dao = new MemberDao();
		
		MemberVo vo1 = new MemberVo();
		vo1.setName("레이첼");
		vo1.setPhone("010-9876-5432");
		vo1.setEmail("Rachel@rachel.com");
		vo1.setPasswd("Sewer");
		testc[0] = dao.insert(vo1);
		
		MemberVo vo2 = new MemberVo();
		vo2.setName("첼이레");
		vo2.setPhone("010-1234-5678");
		vo2.setEmail("lehcaR@lehcaR.com");
		vo2.setPasswd("reweS");
		testc[1] = dao.insert(vo2);
		
		if(testc[0] && testc[1]) {
			System.out.println(vo1.toString());
			System.out.println(vo2.toString());
			
			System.out.println("[Insert Complete]");
		}
		
	}

}

