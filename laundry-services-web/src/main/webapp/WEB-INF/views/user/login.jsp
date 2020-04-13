<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
/* Add some padding on document's body to prevent the content
    to go underneath the header and footer */
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.container {
	width: 80%;
	margin: 0 auto; /* Center the DIV horizontally */
}

.fixed-header, .fixed-footer {
	width: 100%;
	position: fixed;
	background: #333;
	padding: 0px 0;
	color: #fff;
}

.fixed-header {
	top: 0;
}

.fixed-footer {
	bottom: 0;
}
/* Some more styles to beutify this example */
nav a {
	color: #fff;
	text-decoration: none;
	padding: 7px 25px;
	display: inline-block;
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
	width: 5%;
	border-radius: 10%;
}

.container {
	padding: 16px;
}

span.pass {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.pass {
		display: block;
		float: none;
	}
}

.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Login</title>
</head>
<body>
	<div class="fixed-header">
		<div class="container">
			<nav>
				<a href="${pageContext.request.contextPath}/index.jsp">Home</a> <a
					href="${pageContext.request.contextPath}/user/reg">User
					Registration</a> <a href="#">About</a> <a href="#">Contact Us</a>
			</nav>
		</div>
	</div>
	<div class="container">
		<form method="post" action="">
		<form:errors path = "*" cssClass = "errorblock" element = "div" />
		<div style="color: red">${error}</div>
			<div class="imgcontainer">
				<img
					src="${pageContext.request.contextPath}/resources/images/user.png"
					alt="Avatar" class="avatar" />
			</div>
			<fieldset>
				<legend style="color: blue;">Log-in:</legend>
				<table align="center">
					<tr>
						<td><label for="em"><b>Username</b></label></td>
						<td><input type="text" name="em" /></td>
					</tr>
					<tr>
						<td><label for="pass"><b>Password</b></label></td>
						<td><input type="password" name="pass" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Login"
							style="background-color: blue;" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2019 Laundry Services
			Private Ltd</div>
	</div>
</body>
</html>