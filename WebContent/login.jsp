<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<h2>${message }</h2>
<form action="login" method="post"> 
	<table>
		<tr>
			<td>Email ID</td>
			<td><input type="email" name="emailID" value="<%=request.getParameter("emailID")==null?"":request.getParameter("emailID") %>"  ></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" ></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Login"></td>
		<tr>
	</table>
		

</form>
	
</body>
</html>