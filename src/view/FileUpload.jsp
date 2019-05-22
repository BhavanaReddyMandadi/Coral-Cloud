<%@page import="database.*"%>

<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hybrid Cloud</title>
<link href="css/style1.css" rel="stylesheet" type="text/css"
	media="screen" />
<script type="text/javascript">
function num() 
{
var data=document.myform.data.value;
if (data<300){  
 alert("Please Enter minimum 300");  
return false;  
}
}
</script>
<style type="text/css">
.animatedButton2{
text-decoration: none !important;
background-color:#a30e12;
padding-left: 40px;
padding-right: 40px;
height: 38px;
line-height: 38px !important;
display: inline-block;
border: 1px solid #450003;
text-shadow:0px 1px 1px #000;-webkit-box-shadow: inset 0px 1px 1px #fff, 0 5px 0px 0px #450003; -moz-box-shadow: inset 0px 1px 1px #fff, 0 5px 0px 0px #450003; box-shadow: inset 0px 1px 1px #fff, 0 5px 0px 0px #450003;
 -Webkit-border-radius: 5px;
-moz-border-radius: 5px;
border-radius: 5px;

-webkit-transition: all 0.15s linear;
-moz-transition: all 0.15s linear;
-o-transition: all 0.15s linear;
}
.animatedButtonText2{
font-family: Oswald, Arial, sans-serif;
line-height: 38px !important;
font-size: 18px;
color: #EAEAEA;
text-align:center;
-webkit-transition: all 0.15s linear;
-moz-transition: all 0.15s linear;
-o-transition: all 0.15s linear;
transition: all 0.15s linear;
}
.animatedButton2:hover
{
background-color:#880408;
margin-top:5px;-webkit-box-shadow: inset 0px 1px 1px #000, 0 0px 0px 0px #000;-moz-box-shadow: inset 0px 1px 1px #000, 0 0px 0px 0px #000 box-shadow: inset 0px 1px 1px #000, 0 0px 0px 0px #000;
}.animatedButton2:hover .animatedButtonText2
{
text-shadow:0px -1px 1px #000;
 color:#b2161a;
}
</style>
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
<li><a href="login.jsp">Login</a></li>
<li><a href="register.jsp">Register</a></li>
<li id="selected"><a href="progress.jsp">Progress</a></li>
<li><a href="company.jsp">Company</a></li>
<li><a href="admin.jsp">Admin</a></li>
</ul>
</div>
		</div>
<div id="section">
<%String Company = session.getAttribute("Company").toString();
System.out.println(Company);
Connection con;
PreparedStatement ps;
ResultSet rs;
String Cloud="";con=Connections.con();
String query="SELECT cloud FROM `itjcc29`.`hybridreg` where Company='"+Company+"'";
ps=con.prepareStatement(query);
rs=ps.executeQuery();
if(rs.next()){
Cloud=rs.getString(1);
}
%> 
<div id="sec1">
<div id="welcome">
<h2 style="font-family:times new roman; font-style:italic;  color: #9f0ccc">
<%out.print("Welcome To ");%>
<% out.print(Cloud+" Cloud ");%><%=request.getSession().getAttribute("Company")%>
</h2>
</div>
<div id="log">
<button style="margin-top: 30px;margin-left: 60px;background: transparent; border-color: transparent; border-radius:20px; ">
<a href="index.jsp" style="text-decoration: none;margin-top: 20px; color: fuchsia; font-size: 16px;">Logout</a>
</button>
</div>
</div>
<div id="sec2">
<div class="content2">
<div class="grids-heading gallery-heading signup-heading">
<h2>File Upload</h2>
</div>
<form action="Upload" method="post" enctype="multipart/form-data">
<input type="text" name="Company" value="<%=Company %>" readonly="readonly">
<input type="file" name="File">
<input type="submit" class="register" value="Upload">
</form>
</div>
</div>
</div>
<div id="footer">
</div>
</div>
</body></html>
