<%@page import="kr.co.itcen.guestbook.dao.GuestBookDao"%>
<%@page import="kr.co.itcen.guestbook.vo.GuestBookVo"%>
<%
	request.setCharacterEncoding("utf-8");

	int num = Integer.parseInt(request.getParameter("no"));
	Long no = new Long(num);
	String password = request.getParameter("password");

	GuestBookVo vo = new GuestBookVo();
	vo.setNo(no);
	vo.setPassword(password);
	
	new GuestBookDao().delete(vo);
	
	response.sendRedirect(request.getContextPath());
%>