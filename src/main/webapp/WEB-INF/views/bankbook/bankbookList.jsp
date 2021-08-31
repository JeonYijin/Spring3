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
	<table class="table table-striped">
		<tr  class = "table-warning">
			<th>BOOK_NUM</th>
			<th>BOOK_NAME</th>
			<th>BOOK_RATE</th>
			<th>BOOK_SALE</th>
		</tr>
	<c:forEach items="${list}" var = "dto" varStatus="i">
		<tr>
			<td>${dto.book_num}</td>
			<td>${dto.book_name}</td>
			<td>${dto.book_rate}</td>
			<td>${dto.book_sale}</td>
		</tr>

	</c:forEach>

	</table>

	</div>
</div>




</body>
</html>