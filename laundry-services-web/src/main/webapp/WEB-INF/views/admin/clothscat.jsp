<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	align-content: center;
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
<title>Cloths Category</title>
</head>
<body>
	<div class="fixed-header">
		<div class="container">
			<nav>
			     <a href="${pageContext.request.contextPath}/admin/typewash">Type of wash</a>
			    <a href="${pageContext.request.contextPath}/admin/clothscat">Add types of cloths</a>
			    <a href="${pageContext.request.contextPath}/admin/listofwash">List of wash</a>
			     <a href="${pageContext.request.contextPath}/admin/listofcloth">List of cloths</a>
				<a href="#">About</a>
				 <a href="#">Contact Us</a>
				 <a	href="${pageContext.request.contextPath}/user/logout">Sign-Out</a> 
			</nav>
		</div>
	</div>
	<div class="container">
		<form:form method="post" action="${pageContext.request.contextPath}/admin/clothscat"  modelAttribute="clothsCategory">
		<input type="hidden" name="cloth_id" value="${cloth_id}"/>
		<fieldset>
          <legend  style="color: blue;">Fill type of Category:</legend>
			<table width="100%" align="center">
				<tr>
					<td>Enter The Clothtype</td>
					<td><input type="text" name="cloth_type" value="${cloth_type}"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" value="${gender}"/></td>
				</tr>
			</table>
			<input type="submit" name="btn" value="Submit" />
			</fieldset>
		</form:form>
	</div>
	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2019 Laundry Services
			Private Ltd</div>
	</div>
</body>
</html>