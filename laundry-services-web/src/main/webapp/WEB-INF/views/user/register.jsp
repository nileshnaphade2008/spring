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

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}


.container p {
	line-height: 200px; /* Create scrollbar to test positioning */
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
<title>Registration</title>
</head>
<body>
	<div class="fixed-header">
		<div class="container">
			<nav>
			    <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
			    <a	href="${pageContext.request.contextPath}/user/login">Sign-In</a> 
				<a href="#">About</a> <a href="#">Contact Us</a>
			</nav>
		</div>
	</div>
	<div class="container">
		<form:form method="post" modelAttribute="user">
		<form:errors path = "*" cssClass = "errorblock" element = "div" />
		<div style="color: red">${error}</div>
 <fieldset>
  <legend  style="color: blue;">New user registration :</legend>
			<table>

				<tr>
					<td>Enter User Name</td>
					<td><form:input path="user_name" /></td>

				</tr>

				<tr>
					<td>Enter User Email</td>
					<td><form:input path="user_email" /></td>

				</tr>
				<tr>
					<td>Enter Password</td>
					<td><form:password path="user_Password" /></td>


				</tr>
				<tr>
					<td>Enter Phone No</td>
					<td><form:input path="user_mobno" /></td>

				</tr>


				<tr>
					<td>Enter Address</td>
					<td><form:input path="user_address" /></td>
				</tr>

				<tr>
					<td>Choose Role</td>
					<td><form:input path="role" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
			</fieldset>
		</form:form>
	</div>
	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2019 Laundry Services
			Private Ltd</div>
	</div>
</body>
</html>
