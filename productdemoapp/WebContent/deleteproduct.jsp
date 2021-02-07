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

* {
	box-sizing: border-box
}

input[type=text] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus {
	background-color: #ddd;
	outline: none;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

.cancelbtn, .Addproduct {
	float: left;
	width: 100%;
}

.container {
	padding: 16px;
}

.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

@media screen and (max-width: 300px) {
	.cancelbtn, .Addproduct {
		width: 300%;
	}
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

	<form action="ProductUpdateController" method="get">
		<div class="header">
			<h1>Delete Product</h1>
			<p>Please fill the below details to delete a product.</p>
		</div>

		<div class="container">
			<table align="center" cellpadding="8px" cellspacing="8px">
				<tr>
					<td><label for="id1"> Enter Id : </label></td>
					<td><input type="text" name="productid" id="id1"> <br>
					</td>
				</tr>
				<tr>
					<td><label for="id2"> Enter Name: </label></td>
					<td><input type="text" name="productname" id="id2"> <br>
					</td>
				</tr>

				<tr>
					<div class="clearfix">
						<td>
							<button type="submit" class="Addproduct">Delete Product</button>

						</td>
					</div>
				</tr>
			</table>





		</div>
	</form>

</body>
</html>
