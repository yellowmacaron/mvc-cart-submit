<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		${book.id}
		<br>Book Name: ${book.name}
		<br>Author: ${book.author}
		<br>Title:  ${book.title}
		<br>Price: $ ${book.price}
		<br>Stock: ${book.stock}
	
	</ul>
	<input type="button" value="Add to Cart"book
		onclick="window.location.href='cart?command=ADD_TO_CART&bookId=${book.id}'" />
</body>
</html>