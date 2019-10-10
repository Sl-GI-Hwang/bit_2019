<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Spring 이야기</h1>
			<ul>
				<c:choose>
				<c:when test="${empty authUser }">
					<li><a href="${pageContext.servletContext.contextPath }/user/login">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/basic">블로그 관리</a></li>
				</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected">기본설정</li>
					<li><a href="${pageContext.servletContext.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/${authUser.id}/admin/write">글작성</a></li>
				</ul>
				<form action = "${pageContext.servletContext.contextPath}/${authUser.id}/admin/editDefault" method="post" enctype="multipart/form-data">
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" id="title" name="title" value ="${blogvo.title }"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
			      			<td><img id = imgSrc src="${pageContext.servletContext.contextPath}${blogvo.path }"></td>      			
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" id="logomenu" name="logomenu" ></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" id="btn-submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>