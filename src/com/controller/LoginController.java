package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailID = request.getParameter("emailID");
		String password = request.getParameter("password");
		if(UserDao.checkLogin(emailID, password)) {
			request.setAttribute("message", "Login Successfully");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			request.setAttribute("emailID", emailID);
			request.setAttribute("message", "Invalid Credentials");
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
		
	}
}
