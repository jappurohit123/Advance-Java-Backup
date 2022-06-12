<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Users</title>
</head>
<body>
<h1>${message }</h1>
	<%List<UserBean> users = (ArrayList<UserBean>)request.getAttribute("users"); %>
	<table border="1">
		<thead>
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email ID</th>
				<th>Password</th>
				<th>Action</th>
			</tr>
		</thead>	
		<tbody>
			<%for(UserBean u : users) {%>
				<tr>
					<td><%=u.getUserID() %></td>
					<td><%=u.getFirstName() %></td>
					<td><%=u.getLastName() %></td>
					<td><%=u.getEmailID() %></td>
					<td><%=u.getPassword() %></td>
					<td>
						<a href="deleteUser?userID=<%=u.getUserID()%>">Delete User</a> ||
						<a href="">Update User</a>
					
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<a href="home.jsp">Home</a>
</body>
</html>