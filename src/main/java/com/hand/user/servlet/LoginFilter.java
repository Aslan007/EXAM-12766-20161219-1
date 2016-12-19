package com.hand.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.user.bean.Customer;

public class LoginFilter implements Filter {
  

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Customer lm = (Customer)session.getAttribute("customer") ;
	  	if(lm==null)
	  	{
	  		((HttpServletResponse)response).sendRedirect("../login.jsp");
	  		System.out.println("用户未登录未登录");
	  		return;
	  	}
		System.out.println("-------- 后台登录filter before doFilter1-------");
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	  public LoginFilter() {
	    }

		public void destroy() {
		}

}
