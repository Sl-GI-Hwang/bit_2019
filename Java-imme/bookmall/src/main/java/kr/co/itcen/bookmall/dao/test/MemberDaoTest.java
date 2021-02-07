package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.MemberDao;
import kr.co.itcen.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void MemberSelectTest() {
		System.out.println("[Member Select Test]");
		Boolean testc = false;
		MemberDao dao = new MemberDao();
		List <MemberVo> result = new ArrayList<MemberVo>();
		result = dao.select();
		
		dao.printList(result);
		System.out.println("[Select Complete]");
		
	}

	public static void MemberListTest() {
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
