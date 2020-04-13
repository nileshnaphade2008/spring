<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	padding: 10px 0;
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

.container p {
	line-height: 200px; /* Create scrollbar to test positioning */
}
</style>
<title>Logout</title>
</head>
<body>
	<div class="fixed-header">
		<div class="container">
			<nav>
				 <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
				 <a	href="${pageContext.request.contextPath}/user/login">Sign-In</a> 
			   <a href="${pageContext.request.contextPath}/user/reg">User Registration</a>
				<a href="#">About</a> <a href="#">Contact Us</a>
			</nav>
		</div>
	</div>
	<div class="container">

		<h3>Hello , ${requestScope.u_dtls.name}</h3><h3>You have logged out</h3>
		<h3>Log-in again <a	href="${pageContext.request.contextPath}/user/login">Sign-In</a> </h3>
</body>
</div>
<div class="fixed-footer">
	<div class="container">Copyright &copy; 2019 Laundry Services
		Private Ltd</div>
</div>
</html>