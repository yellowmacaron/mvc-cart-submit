
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style>
* {
	box-sizing: border-box;
}

.sub-body {
	float: left;
	width: 30%;
	padding: 10px;
}

.body:after {
	content: "";
	display: table;
	clear: both
}
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<form action="home">
			<input type="text" name="bookName" value="${param.bookName}">
			<input type="submit">
		</form>
	</div>
	<c:if test="${empty username}">
		<a href="login.jsp">Login</a>
		<a href="register.jsp">Register</a>

	</c:if>

	<c:if test="${not empty username}">
Hello ${username}
<a href="logout">Logout</a>
	</c:if>

	<c:if test="${empty sessionScope.cart}">
(0)</c:if>

	<c:if test="${not empty sessionScope.cart}">
		<a href="cart?command=VIEW_CART">Cart(${empty sessionScope.cart? 0 : sessionScope.cart.size()})</a>
	</c:if>


	</div>

	</div>

	<hr>
	<div class="body">
		<div class="sub-body">
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		<div class="sub-body">
			<c:if test="${empty bookList and empty bookListBySearch}">
			No Book
		</c:if>
			<c:if test="${not empty bookList}">
				<ul>
					<c:forEach var="book" items="${pageBooks}">
						<a href="book?bookId=${book.id}">
							<li>${book.name}</li>
						</a>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${not empty bookListBySearch}">
				<ul>
					<c:forEach var="book" items="${bookListBySearch}">
						<a href="book?bookId=${book.id}">
							<li>${book.name}</li>
						</a>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<c:if test="${not empty currentPage and totalPages > 1}">
			<div class="pagination">
				<c:if test="${currentPage > 1}">
					<a href="home?page=${currentPage - 1}">&laquo; Previous</a>
				</c:if>
				<c:forEach var="page" begin="1" end="${totalPages}">
					<c:choose>
						<c:when test="${currentPage == page}">
							<span class="current-page">${page}</span>
						</c:when>
						<c:otherwise>
							<a href="home?page=${page}">${page}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${currentPage < totalPages}">
					<a href="home?page=${currentPage + 1}">Next &raquo;</a>
				</c:if>
			</div>
		</c:if>
	</div>

	
	
</body>
</html>