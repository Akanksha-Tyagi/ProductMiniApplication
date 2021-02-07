<%@page import="com.productapp.product.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-image: url('product.png');
}

.header {
	padding: 20px;
	text-align: center;
	background: #1abc9c;
	color: red;
	font-size: 15px;
}
</style>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
	<div class="header">
		<h1>Welcome To Product Application.</h1>
		<p>on the basis of your preferences please select a suitable
			option.</p>
	</div>
	<div>

		<table align="center" cellpadding="8px" cellspacing="8px">
			<tr>
				<td><label for="id1"> 1: </label></td>
				<td><a href="ProductController">Show All products</a> <br></td>
			</tr>
			<tr>
				<td><label for="id2"> 2: </label></td>
				<td><a href="addproduct.jsp">Add Product</a> <br></td>
			</tr>
			<tr>
				<td><label for="id3"> 3: </label></td>
				<td><a href="deleteproduct.jsp">Delete Product</a> <br></td>
			</tr>
			<tr>
				<td><label for="id4"> 4: </label></td>
				<td><a href="updateproduct.jsp">Update Existing Product</a> <br>
				</td>
			</tr>


		</table>
</body>

</html>
