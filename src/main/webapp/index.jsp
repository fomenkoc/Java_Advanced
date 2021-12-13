<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Magazines.ua - Login</title>
<link rel="stylesheet" href="./styles/main.css">
</head>
<body>

	<div class="main">
		<div class="loginDiv">
			<h1>Magazines.ua</h1>
			<form action="login" method="post" class="loginForm">
			<label>Email:</label> 
			<input type="text" class="iEmail" name="email">
			<br>
			<label>Password:</label>
			<input type="password" class="iPassword" name="password">
			<br>
			<br>
			<a href="registration.jsp">Registration</a>
			<input type="submit" value="Login" class="bLogin button">
			</form>
			
		</div>
	</div>

</body>
</html>