package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.ValidationClass;

public class SignUpController extends HttpServlet{
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean();
		System.out.println("In signup controller");
		user.setFirstName(request.getParameter("firstName"));					
		user.setLastName(request.getParameter("lastName"));						
		user.setEmailID(request.getParameter("emailID"));					
		user.setPassword(request.getParameter("password"));
		if(UserDao.insertUser(user)) {
			request.setAttribute("message", "Insert users properly");
		}else {
			request.setAttribute("message", "Error while inserting the user");				
		}	
		request.getRequestDispatcher("Message.jsp").forward(request, response);		
	}
}
