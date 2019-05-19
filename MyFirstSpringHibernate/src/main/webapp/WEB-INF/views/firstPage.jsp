<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoggedIn</title>
</head>
<body>
	LoggedIn successfully!!! Hi ${user.username}
	<br><br>
	Change Password:
	<form action="saveNewPassword" method="POST"> 
		Enter Old Password:
		<input type="text" name="oldPassword"/>
		<br> 
		Enter New Password:		
		<input type="text" name="newPassword"/> 
		
		<input type="submit" value="submit"> 
	</form>
	<br><br>
	Change Email:
	<form action="saveNewEmail" method="POST"> 
		Enter Password:
		<input type="text" name="password"/>
		<br> 
		Enter New Email:		
		<input type="text" name="email"/> 
		
		<input type="submit" value="submit"> 
	</form><br><br>
	Delete User:
	<form action="deleteUser" method="POST"> 
	Enter Password:
		<input type="text" name="password"/>
		<br>
		<input type="submit" value="Delete User"> 
	</form>
</body>
</html>