<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>Registration Successful</title>
</head>
<body bgcolor="DDDDDD">
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
	      <h3> Welcome  ${user.user_name}, you are successfully register to avail the Laundry Services !!!.<a></a></h3>
		 <fieldset>
            <legend>User Details :</legend>
			 User Id: ${user.user_id}<br />
			 First Name: ${user.user_name}<br /> 
			 Email Id: ${user.user_email}<br />
		     Contact#: ${user.user_mobno}<br /> 
		     Role Type: ${user.role}<br /> 
			 Address: ${user.user_address}<br />
		</fieldset>
	</div>
	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2019 Laundry Services
			Private Ltd</div>
	</div>
</body>
</html>
