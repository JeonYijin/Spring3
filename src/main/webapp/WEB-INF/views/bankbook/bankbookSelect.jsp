<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>BankBook Select Page</h1>
	
	<div class="container-fluid">
		<h3>BOOK_NUM: ${dtov.book_num} </h3>	
		<h3>BOOK_NAME: ${dtov.book_name}</h3>
		<h3>BOOK_RATE: ${dtov.book_rate}</h3>
		<h3>BOOK_SALE: ${dtov.book_sale}</h3>
		
		<a href="./bankbookDelete?book_num=${dtov.book_num}">Delete</a>
	</div>
	
	
</body>
</html>