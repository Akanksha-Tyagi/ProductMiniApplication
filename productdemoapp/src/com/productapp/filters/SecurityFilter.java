package com.productapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.productapp.user.UserDetails;

public class SecurityFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {System.out.println("in security filter init");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("in security filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		boolean isLogin = false;

		HttpSession httpSession = req.getSession(false);
		System.out.println(httpSession);
		if (httpSession != null) {
			UserDetails user = (UserDetails) httpSession.getAttribute("user");
			if (user != null) {
				isLogin = true;
			}
		}
		if (isLogin) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("login.jsp?error=please login");
		}
	}

	public void destroy() {
	}

}