package com.productapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.user.service.UserService;
import com.product.user.service.UserServiceImpl;
import com.productapp.user.UserDetails;
import com.productapp.user.UserNotFoundException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in login controller");
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		try {
			UserDetails user = userService.getUser(username, password);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		} catch (UserNotFoundException ex) {
			response.sendRedirect("login.jsp?error=login failed!");
		}

	}

}