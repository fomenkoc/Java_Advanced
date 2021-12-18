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
			
			
			<label>Email:</label> 
			<input type="text" class="iEmail" name="email">
			<br>
			<label>First Name:</label> 
			<input type="text" class="iFirstName" name="firstName">
			<br>
			<label>Last Name:</label> 
			<input type="text" class="iLastName" name="lastName">
			<br>
			<label>Password:</label>
			<input type="password" class="iPassword" name="password">
			<br>
			<label>Confirm Password:</label>
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