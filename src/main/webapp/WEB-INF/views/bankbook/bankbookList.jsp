<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	
<h1>List renewal</h1>

<div class="container-fluid">
	<div class="col-md-8 mx-auto my-0">
		<table class="table table-hover">
			<tr>
				<th>BOOK_NUM</th>
				<th>BOOK_NAME</th>
				<th>BOOK_RATE</th>
			</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.book_num}</td>
				<td><a href="./bankbookSelect?book_num=${dto.book_num}">${dto.book_name}</a></td>
				<td>${dto.book_rate}</td>
			</tr>
		</c:forEach>
		</table>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			<a href="./bankbookList?pn=${n}">${n}</a>
		
		</c:forEach>
		
		<a href="./bankbookInsert" class="btn btn-danger">ADD</a>
		
	</div>

</div>

</body>
</html>