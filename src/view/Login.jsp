<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hybrid Cloud</title>
<link href="css/style1.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
<div id="full">
<div id="header">
<div id="logo">
<img alt="img" src="images/logos.png" height="150" width="200">
</div>
<div id="logo1">
<img alt="img" src="images/logo1.png" height="130" width="350">
</div>
<div id="nav">
<ul>
<li><a href="index.jsp">Home</a></li>
<li id="selected"><a href="login.jsp">Login</a></li>
<li><a href="register.jsp">Register</a></li>
<li><a href="progress.jsp">Progress</a></li>
<li><a href="company.jsp">Company</a></li>
<li><a href="admin.jsp">Admin</a></li>
</ul>
</div>
</div>
<div id="section">
<div class="content2">
<div class="grids-heading gallery-heading signup-heading">
					<h2>Sign Up</h2>
</div>
<form action="Login" method="post">
<input type="text" name="Company" placeholder="Company" >
<input type="email" name="Email" placeholder="Email">
<input type="password" name="Password" placeholder="Password" >
<input type="submit" class="register" value="Sign Up">
</form>
<a href="register.jsp">Register Here</a>
</div>
</div>
<div id="footer">
</div>
</div>
</body>
</html>
