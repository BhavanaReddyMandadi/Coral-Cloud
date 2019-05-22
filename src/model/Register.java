Package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.RegisterBean;
import implement.implementation;
import interfaces.interfaces;
/** * Servlet implementation class Register*/
@WebServlet("/Register")
public class Register extends HttpServlet {
private static final long serialVersionUID = 1L;
  /** @see HttpServlet#HttpServlet() */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub 
response.getWriter().append("Served at: ").append(request.getContextPath());
}
/***@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stubdoGet(request, response);
String Company = request.getParameter("Company");
String Email = request.getParameter("Email");
String Password = request.getParameter("Password");
String Cloud = request.getParameter("cloud");
String Phone = request.getParameter("Phone");
RegisterBean rb = new RegisterBean();rb.setCompany(Company);rb.setEmail(Email);
rb.setPassword(Password);
		rb.setCloud(Cloud);
		rb.setPhone(Phone);
		interfaces ifs = new implementation();
		int i = ifs.register(rb);
		if (i == 1) {
		response.sendRedirect("login.jsp");
		} else {
		response.sendRedirect("error.jsp");
}}}
