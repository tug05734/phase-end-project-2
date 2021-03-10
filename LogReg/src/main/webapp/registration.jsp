<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration</h1>
	<form action="userReg" method="post">
			<label for="name">Name:</label>
			<input type="text" placeholder="full name" id="name" name="name"><br><br>
			<label for="email">E-mail:</label>
			<input type="text" placeholder="email" id="email" name="email"><br><br> 
			<label for="password">Password:</label>
			<input type="text" placeholder="password" id="password" name="password"><br><br> 
			<br> <input type="submit" value="Submit"><br><br>
			<small>All fields must be filled</small>
	</form>
</body>
</html>