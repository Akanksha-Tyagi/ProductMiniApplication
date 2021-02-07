package com.productapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.productapp.dao.DataAccessException;
import com.productapp.product.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

// This is the controller that manages the request.

public class ProductUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in  do get to delete");
		String bookName = request.getParameter("productname");
		int bookId = Integer.parseInt(request.getParameter("productid"));
		try {
			System.out.println("in try");

			Product deletedproduct = productService.deleteProduct(bookId, bookName);
			System.out.println("doget Deleted product name is: " + deletedproduct.getName());

			System.out.println("in try end");
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do post for update");
		int productId = Integer.parseInt(request.getParameter("productid"));
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		try {
			System.out.println("in try");

			Product updateproduct = productService.updateProduct(productId,price, quantity);
			System.out.println("dopost updated product name is: " + updateproduct.getName());

			System.out.println("in try end");
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
	}

}
