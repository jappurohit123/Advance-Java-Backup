package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.UserDao;

/**
 * Servlet Filter implementation class DuplicateEmailChecker
 */
public class DuplicateEmailChecker implements Filter {

    public DuplicateEmailChecker() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("In Duplicate Email Checker");
		String emailID = request.getParameter("emailID");
		if(UserDao.duplicateEmailChecker(emailID)) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("emailIDError", "Duplicate Email ID! Please try to use another email ID");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Duplicate Email Checker Filter");
	}

}
