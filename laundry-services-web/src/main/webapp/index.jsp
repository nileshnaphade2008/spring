<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	margin-left: 1px;
	overflow-y: hidden; /* Hide vertical scrollbar */
  overflow-x: hidden; /* Hide horizontal scrollbar */
}
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 10%;
  border-radius: 15%;
}

.container {
	width: 80%;
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
.img-background{
   height: 990%;
   object-fit:contain;
   max-height: 50%;
   max-width: 100%;    
   display: block;
   margin: auto auto;
}
</style>
<title>Laundry Services</title>
</head>
<body>
	<div class="fixed-header">
		<div class="container">
			<nav>
				<a href="#">Home</a> <a href="user/reg">User Registration</a> <a
					href="user/login">Sign-In</a> <a href="#">About</a> <a href="#">Contact
					Us</a>
			</nav>
		</div>
	</div>
	<div class="container">
	<form method="post" action="${pageContext.request.contextPath}/user/login">
	<table>
	<tr>
        <td><img src="${pageContext.request.contextPath}/resources/images/laundryservice.png" alt="Laundry Service" class="img-background"/></td>
        <td>
		<div class="imgcontainer">
           <img src="${pageContext.request.contextPath}/resources/images/user.png" alt="Avatar" class="avatar"/>
        </div>
	  <fieldset>
          <legend  style="color: blue;">Log-in:</legend>
			<table>
				<tr>
					<td><label for="em"><b>Username</b></label></td>
					<td><input type="text" name="em" /></td>
				</tr>
				<tr>
					<td> <label for="pass"><b>Password</b></label></td>
					<td><input type="password" name="pass" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Login" style="background-color: blue;"/></td>
				</tr>
			</table>
			</fieldset>
		</td>
        </tr>
        </table>
        </form>
	</div>
	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2019 Laundry Services Private Ltd</div>
	</div>
</body>
</html>