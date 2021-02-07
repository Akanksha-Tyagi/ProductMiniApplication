<%@page import="com.productapp.product.Product"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>


	<%
		List<Product> allProductList = (ArrayList<Product>) session.getAttribute("allProductList");
	%>

	<table cellspacing="2" cellpadding="2">

		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<th>Product ManufactureDate</th>
			<th>Product InspectedDate</th>
		</tr>

		<%
			// Iterating through product List

			Iterator<Product> iterator = allProductList.iterator();

			while (iterator.hasNext()) {
				Product productDetails = iterator.next();
		%>
		<tr>
			<td><%=productDetails.getId()%></td>
			<td><%=productDetails.getName()%></td>
			<td><%=productDetails.getPrice()%></td>
			<td><%=productDetails.getQuantity()%></td>
			<td><%=productDetails.getMandate()%></td>
			<td><%=productDetails.getInsdob()%></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>
