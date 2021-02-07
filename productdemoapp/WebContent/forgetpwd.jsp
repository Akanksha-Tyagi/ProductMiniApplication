
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}




.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	
}
</style>
<meta charset="UTF-8">
<title>Forget Application</title>
</head>
<body>
	<!-- EL Expression languge -->
	${param.error}
	<br> ${param.message }
	<br>
	<br>

	<h2>Forget Password Form</h2>

	<form action="ForgetPasswordController" method="post">
		<div class="imgcontainer">
			<img src="login.png" alt="Login Image"
				class="avatar">
		</div>

		<div class="container">
		<label for="uname"><b>Enter Username: </b></label> <input type="text"
				placeholder="Enter UserName" name="username" required>
			<label for="pwd"><b>Enter New Password: </b></label> <input type="password"
				placeholder="Enter New Password" name="password" required> <label
				for="conpwd"><b>Enter Confirm  Password: </b></label> <input type="password"
				placeholder="Enter Confirm  Password" name="confirmpassword" required>

			<button type="submit">Change Password</button>
			
		</div>

		<div class="container" style="background-color: #f1f1f1">
			
			<span class="psw">Go To <a href="login.jsp">LogIn?</a></span>
		</div>
	</form>
</body>
</html>