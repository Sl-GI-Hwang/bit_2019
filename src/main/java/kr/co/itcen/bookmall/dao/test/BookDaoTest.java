package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void BookSelectTest() {
		System.out.println("[Book Select Test]");
		Boolean testc = false;
		BookDao dao = new BookDao();
		List <BookVo> result = new ArrayList<BookVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Select Complete]");
	}

	public static void BookListTest() {
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

}
