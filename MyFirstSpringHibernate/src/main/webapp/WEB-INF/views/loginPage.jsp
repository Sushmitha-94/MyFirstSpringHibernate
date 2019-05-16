<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
Login:
	<form action="loginValidate" method="POST"> 
		Username :
		<input type="text" name="username"/>
		<br> Password :
		<input type="text" name="password"/> 
		
		<input type="submit" value="submit"> 
	</form>
	
	<br><br>
	Sign Up:
	<form action="signUp" method="POST"> 
		Please enter your username: 
		<input type="text" name="username"/>
		<br> Please enter your password 
		<input type="text" name="password"/> 
		<br> Please enter your Email 
		<input type="text" name="email"/> 
		<input type="submit" value="submit"> 
	</form>
</body>
</html>