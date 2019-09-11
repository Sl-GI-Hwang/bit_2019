package kr.co.itcen.bookmall.dao.test;

public class MainTest {

	public static void main(String[] args) {
		
		MemberDaoTest.MemberListTest();
		MemberDaoTest.MemberSelectTest();

		CategoryDaoTest.CategoryListTest();
		CategoryDaoTest.CategorySelectTest();

		BookDaoTest.BookListTest();
		BookDaoTest.BookSelectTest();

		CartDaoTest.CartListTest();
		CartDaoTest.CartSelectTest();

		OrderDaoTest.OrderListTest();
		OrderDaoTest.OrderSelectTest();

		// Join 구현
		OrderBookDaoTest.OrderBookListTest();
		OrderBookDaoTest.OrderBookSelectTest();

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

}
