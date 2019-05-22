<%@page import="database.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hybrid Cloud</title>
<link href="css/style1.css" rel="stylesheet" type="text/css"media="screen" />
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
.number{
 padding: 10px;
 width: 90%;
 border: 1px solid black;
 color: #000;
 text-align: left;
 outline: none;
 font-size: 1em;
 margin-top: 5%;
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
<%String Company=session.getAttribute("Company").toString();System.out.println(Company);%> 
<div id="sec1">
<div id="welcome">
<h2 style="font-family:times new roman; font-style:italic;  color: #9f0ccc">
<%-- <%out.print("Welcome To Hybrid Cloud ");%>
<%=request.getSession().getAttribute("Company")%>--%>
<%String Cloud="";String Account1="";Connection con;PreparedStatement ps,ps1;
con=Connections.con();String query="SELECT cloud FROM `itjcc29`.`hybridreg` where company='"+Company+"'";ps=con.prepareStatement(query);ResultSet rs=ps.executeQuery();
if(rs.next()){
Cloud=rs.getString(1);
}
String query1="SELECT Account FROM `itjcc29`.`bankregister` where Username='"+Cloud+"'";ps1=con.prepareStatement(query1);ResultSet rs1=ps1.executeQuery();
if(rs1.next()){
Account1=rs1.getString(1);HttpSession sess = request.getSession();
session.setAttribute("Account1", Account1);
}
%>
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
<h2>Cloud Data Space</h2>
</div>
<form action="banklogin.jsp" method="post" name="myform">
<input type="number" class="number" name="data" onchange="num()" placeholder="minimum value is 300" required="required"/>
<input type="text" class="number" name="Account" value="<%=Account1 %>"
readonly="readonly"/>
<input type="submit" class="register" value="Make a payment">
</form>
</div>
</div>
</div>
<div id="footer">
</div>
</div>
</body>
</html>
