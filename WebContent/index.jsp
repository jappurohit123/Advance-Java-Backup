<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Home Page</h1>
<form action="signup" method="post">
<!-- HTML5 
		required 
		max
		min
		email = "@"
EL Tag : $  : Display
 -->
	<table>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="firstName" value="<%=request.getParameter("firstName")==null?"":request.getParameter("firstName") %>"></td>
			<td>${firstNameError }</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lastName" value="<%=request.getParameter("lastName")==null?"":request.getParameter("lastName") %>"></td>
			<td>${lastNameError }</td>
		</tr>
		<tr>
			<td>Email ID</td>
			<td><input type="email" name="emailID" value="<%=request.getParameter("emailID")==null?"":request.getParameter("emailID") %>"  ></td>
			<td>${emailIDError }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"  value="<%=request.getParameter("password")==null?"":request.getParameter("password") %>" ></td>
			<td>${passwordError }</td>
		</tr>
		
		<tr>
			<td><input type="submit" name="SignUp"></td>
		<tr>
	</table>


</form>
</body>
</html>