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
<script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
<script>
$(function(){
	$(document).on("click", ".admin-cat img", function(){
		var categoryNo = $(this).attr('id');
		var thisObj = $(this);
		
		$.ajax({
			url: "${pageContext.servletContext.contextPath }/${authUser.id }/admin/delete",
			type: "POST",
			dataType: "json",
			data: {
				"blogId": "${authUser.id }",
				"categoryNo": categoryNo},
			success: function( result ){
			     if( result ){
			        // 삭제 버튼을 누른 row 제거
			        $(thisObj).parent().parent().remove();
			      }
			    },
			error: function( err ){
				console.log(err)
			}
		});	
		
	});
	
	$("#btn-add-category").click(function(){
		var categoryNo = $("#desc").val();
		
		$.ajax({
		    url: "${pageContext.servletContext.contextPath}/${authUser.id }/admin/insertCat",
		    type: "POST",
		    data: {
		      "blogId": "${authUser.id }",
		      "name": $("#name").val(),
		      "contents": $("#desc").val()
		    },
		    dataType: "json",
		    success: function(result){
		    	if(result.success) {
		    		categoryList = result.categoryList;
			    	getPostCount = result.getPostCount;
			    	
			    	removeTable();
				    createNewTable(categoryList, getPostCount);	    		
		    	}
		    },
		    error: function( err ){
		      	console.log(err)
		    }
		  })
	});
	
	function removeTable(){
		  // 원래 테이블 제거
		  $(".origin-tbody").remove();
		  // ajax로 추가했던 테이블 제거
		  $(".new-tbody").remove();
		  // 입력 form 초기화
		  $("#name").val("");
		  $("#desc").val("");
	}

	function createNewTable(categoryList, getPostCount){
		  $newTbody = $("<tbody class='new-tbody'></tbody>")
		  $(".admin-cat").append($newTbody)
			
		  for(let category in categoryList){
			  for(let postnum in getPostCount) {
				  if(categoryList[category].categoryNo == getPostCount[postnum].categoryNo) {
					  var postcount = getPostCount[postnum].count;
				  }
			  }
			  $newTbody.append(
			   	"<tr>" +
		        "<td>" + 7 + "</td>" +
		        "<td>" + categoryList[category].name + "</td>" +
		        "<td>" + postcount + "</td>"+
		        "<td>" + categoryList[category].contents + "</td>" +
		        "<td>" +
		        "<img src='${pageContext.servletContext.contextPath}/assets/images/delete.jpg'" +
		        "id="+categoryList[category].categoryNo+">" +
		        "</td>" +
		        "</tr>");
		  }
	}
});
</script>
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
					<li><a href="${pageContext.servletContext.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="${pageContext.servletContext.contextPath}/${authUser.id}/admin/write">글작성</a></li>
				</ul>
		      	<table class="admin-cat">
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
			      	</thead>
			      	<tbody class = "origin-tbody">
		      		<c:forEach var="category" items="${categoryList }">
		      		<tr>
						<td>3</td>
						<td>${category.name}</td>
						
						<c:forEach var="postnum" items="${getPostCount }">
							<c:if test="${category.categoryNo == postnum.categoryNo }">
								<td>${postnum.count}</td>
							</c:if>
						</c:forEach>
						<td>${category.contents}</td>
						<td><img src="${pageContext.servletContext.contextPath}/assets/images/delete.jpg" id="${category.categoryNo}"></td>
					</tr>
					</c:forEach>	
					</tbody>				  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" id = "name" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" id = "desc" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input id="btn-add-category" type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
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