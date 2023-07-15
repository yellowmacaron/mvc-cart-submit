<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<style>
form {
	border: 3px solid #f1f1f1;
}
/* Add padding to containers */
.container {
	padding: 16px;
}

/* The "Forgot password" text */
span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">

		<div class="container">
			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" required> <br>
			<label for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required> <br>
			<div class="container">
				<button type="submit">Log in</button>

			</div>

		</div>
	</form>
	<c:if test="${not empty errorMessage}">
		<p style="color: red">${errorMessaged}</p>
	</c:if>
</body>
</html>