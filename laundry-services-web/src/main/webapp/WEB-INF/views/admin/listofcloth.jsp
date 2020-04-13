<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>List of Cloths</title>
</head>
<body>
	<div class="fixed-header">
		<div class="container">
			<nav>
				<a href="${pageContext.request.contextPath}/admin/typewash">Type
					of wash</a> <a
					href="${pageContext.request.contextPath}/admin/clothscat">Add
					types of cloths</a> <a
					href="${pageContext.request.contextPath}/admin/listofwash">List
					of wash</a> <a
					href="${pageContext.request.contextPath}/admin/listofcloth">List
					of cloths</a> <a href="#">About</a> <a href="#">Contact Us</a> <a
					href="${pageContext.request.contextPath}/user/logout">Sign-Out</a>
			</nav>
		</div>
	</div>
	<div class="container">
		<fieldset>
			<legend style="color: blue;">List of Cloths:</legend>
			<table border="" width="100%">

				<c:forEach var="c" items="${requestScope.cloths_list}">
					<tr>

						<td>${c.cloth_type}</td>
						<td>${c.gender}</td>
						<td><a
							href="<spring:url value='/admin/updatecloths?cloth_id=${c.cloth_id}'/>">Update</a></td>
						<td><a
							href="<spring:url value='/admin/deletecloths?cloth_id=${c.cloth_id}'/>">Delete</a></td>

					</tr>
				</c:forEach>
			</table>


		</fieldset>
	</div>
	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2019 Laundry Services
			Private Ltd</div>
	</div>
</body>
</html>