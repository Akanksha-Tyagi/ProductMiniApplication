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

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();
	List<Product> allProductList;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in addp controller do get");
		try {
			allProductList = productService.allProduct();
			for (Product productitem : allProductList) {
				System.out.println(productitem.toString());
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("allProductList", allProductList);
		response.sendRedirect("showproducts.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in addp controller do post");
		response.setContentType("text/html");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		String manfdate = request.getParameter("mandate");
		String insdate = request.getParameter("insdate");
		SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy");

		Date manfdob = null;
		try {
			manfdob = formate.parse(manfdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat formate1 = new SimpleDateFormat("dd/MM/yyyy");

		Date insdob = null;
		try {
			insdob = formate1.parse(insdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Product product = new Product(name, price, quantity, manfdob, insdob);
		try {
			System.out.println("in try");
			product = productService.addProduct(product);
			System.out.println(product.toString());
			List<Product> allProductList = productService.allProduct();
			for (Product productitem : allProductList) {
				System.out.println(productitem.toString());
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("product", product);
		response.sendRedirect("success.jsp");

	}

}
