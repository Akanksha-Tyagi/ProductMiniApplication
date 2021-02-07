package com.productapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.user.service.UserService;
import com.product.user.service.UserServiceImpl;

public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		System.out.println("in Forgetcontroller");
		String userName = request.getParameter("username");
		String newpassword = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		System.out.println(newpassword);
		System.out.println(confirmpassword);
		if (newpassword.equals(confirmpassword)) {
			System.out.println("password equal");
			userService.updatePassword(newpassword, userName);
		} 
		else {
			response.sendRedirect("login.jsp?error=login failed!");
		}

	}

}