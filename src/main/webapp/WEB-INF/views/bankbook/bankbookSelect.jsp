<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Select Page</h1>

	<h2>${dto.getBook_name()}</h2>
	
	<h2>BOOK_NUM: ${dto.book_num}</h2>	
	<h2>BOOK_NAME: ${dto.book_name}</h2>
	<h2>BOOK_RATE: ${dto.book_rate}</h2>
</body>
</html>