<%@page import="com.productapp.product.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
success, product is added to Database
<%
	Product product=(Product)session.getAttribute("product");
	System.out.println(product);
	out.print("product id: "+product.getId()+"<br>");
	out.print("product name: "+product.getName()+"<br>");
	out.print("product price: "+product.getPrice()+"<br>");
	out.print("product quantity: "+product.getQuantity()+"<br>");
	out.print("product manufacture dob: "+product.getMandate()+"<br>");
	out.print("product Inspected dob: "+product.getInsdob()+"<br>");
%>
</body>
</html>
