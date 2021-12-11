<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Magazines.ua - Registration</title>
<link rel="stylesheet" href="./styles/main.css">
</head>
<body>

	<div class="main">
		<div class="loginDiv">
			<h1>Magazines.ua</h1>
			<form action="registration" method="post" class="loginForm">
			
			<label>UserName:</label> 
			<input type="text" class="iUserName" name="userName">
			<br>
			<label>Email:</label> 
			<input type="text" class="iEmail" name="email">
			<br>
			<label>Password:</label>
			<input type="password" class="iPassword" name="password">
			<br>
			<label>RePassword:</label>
			<input type="password" class="iRePassword" name="rePassword">
			<br>
			<br>
			<a href="index.jsp">Login</a>
			<input type="submit" value="Registration" class="bLogin button">
			
			</form>
			
		</div>
	</div>

</body>
</html>