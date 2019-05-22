Package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.RegisterBean;
import implement.implementation;
import interfaces.interfaces;
/*** Servlet implementation class Login */
@WebServlet("/Login")
Public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;
 /*** @see HttpServlet#HttpServlet()*
 public Login() {
  super();
        // TODO Auto-generated constructor stub
    }
/***@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
}
/* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String Company=request.getParameter("Company");
		HttpSession session = request.getSession();
	session.setAttribute("Company", Company);
		String Email=request.getParameter("Email");
String Password=request.getParameter("Password");
RegisterBean rgb=new RegisterBean();
rgb.setCompany(Company);
rgb.setEmail(Email);
rgb.setPassword(Password);
interfaces ifs=new implementation();
int i=ifs.login(rgb);
if(i==1){
response.sendRedirect("progress1.jsp");
}
else{
response.sendRedirect("error.jsp");
}}}
