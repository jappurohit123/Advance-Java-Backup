<%@page import="com.listener.ServerRequestListner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home JSP</title>
</head>
<body>
	<h1>Home Page</h1>
	<h2>${message }</h2>
	<h2>${name}</h2>
	<h2>Request Generated ${ServerRequestListner.requestCount()}</h2>
	<a href="index.jsp">Add User</a> | <a href="listAllUsers">List Users</a>
</body>
</html>