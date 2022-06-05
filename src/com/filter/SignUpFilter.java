package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.ValidationClass;

/**
 * Servlet Filter implementation class SignUpFilter
 */
public class SignUpFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SignUpFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Filter Destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("In Signup filter");
		String emailID = request.getParameter("emailID");		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		boolean isValid = true;
		
		if(ValidationClass.textValidation(firstName)) {
			isValid = false;
			request.setAttribute("firstName", firstName);
			request.setAttribute("firstNameError", "Please enter valid First Name");
		}
		
		if(ValidationClass.textValidation(lastName)) {
			isValid = false;
			request.setAttribute("lastName", lastName);			
			request.setAttribute("lastNameError", "Please enter valid Last Name");			
		}
		
		if(ValidationClass.textValidation(emailID)) {
			isValid = false;
			request.setAttribute("emailID", emailID);						
			request.setAttribute("emailIDError", "Please enter valid Email-ID");			
		}
		
		if(!ValidationClass.passwordValidation(password)) {
			isValid = false;
			request.setAttribute("password", password);			
			request.setAttribute("passwordError", "Please enter valid Password");			
		}
		
		if(isValid) {
			chain.doFilter(request, response);
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Started the filter");
	}

}
