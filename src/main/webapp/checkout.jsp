<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>Order details</title>
 <h2>Your order details:</h2>
    <c:forEach var="book" items="${booksInOrderDetail}">
        <p>Book Name: ${book.name} --- Price: ${book.price}</p>
    </c:forEach>
    	<h3> Total: $${total} </h3>
</body>
</html>