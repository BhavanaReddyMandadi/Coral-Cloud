Package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.DataRequestBean;
import implement.implementation;
import interfaces.interfaces;
/*** Servlet implementation class DataRequest*/
@WebServlet("/DataRequest")
public class DataRequest extends HttpServlet {
private static final long serialVersionUID = 1L;
/** * @see HttpServlet#HttpServlet() */
public DataRequest() {
super();
// TODO Auto-generated constructor stub
}
/***@seeHttpServlet#doGet(HttpServletRequestrequest,HttpServletResponse *response)*/
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
{
// TODO Auto-generated method stubresponse.getWriter().append("Served at").append(request.getContextPath());
String Company = request.getSession().getAttribute("Company").toString();
String Company1 = request.getParameter("Company1");
System.out.println("Company="+Company);
System.out.println("Company1111111="+Company1);
String Data = request.getParameter("Data");
System.out.println("Dataaaaaaaaaaaa="+Data);
String Amount = request.getParameter("Amount");
System.out.println("Amount="+Amount);
DataRequestBean drb = new DataRequestBean();
drb.setCompany(Company);
drb.setCompany1(Company1);
drb.setData(Data);
drb.setAmount(Amount);
interfaces ifs = new implementation();
int i = ifs.datarequesst(drb);
if (i == 1) {
response.sendRedirect("dataresponse.jsp");
}
Else
 {
Response.sendRedirect("error.jsp");
}
}
/***@seeHttpServlet#doPost(HttpServletRequestrequest,HttpServletResponse *response) */
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}}
