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

	<h1>Insert Page</h1>
	
<div class="container-fluid">
	<form class= "col-md-5 mx-auto" action="./bankbookInsert" method="post">
		<div class="mb-3">
			  <label for="book_name" class="form-label">BOOK_NAME</label>
			  <input type="text" class="form-control"name ="book_name" id="book_name" placeholder="ENTER BOOK_NAME">
		</div>
		<div class="mb-3">
			  <label for="book_rate" class="form-label">BOOK_RATE</label>
			  <input type="text" class="form-control" name ="book_rate"id="book_rate" placeholder="0.00~9.99">
		</div>
		
		<div class="form-check">
		 	<input class="form-check-input" type="radio" name="book_sale" value="1" id="flexRadioDefault1">
		 	<label class="form-check-label" for="book_sale">
		    SALE
		 	</label>
		</div>
		<div class="form-check">
		  	<input class="form-check-input" type="radio" name="book_sale" value="0" id="flexRadioDefault2" checked>
		 	<label class="form-check-label" for="book_sale">
			NOT SALE
		 	</label>
		</div>

		<button type="submit" class="btn btn-success">ADD</button>
	</form>
	
</div>
	
</body>
</html>