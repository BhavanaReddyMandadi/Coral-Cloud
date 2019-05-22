package servlet;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import bean.UploadBean;
import database.Connections;
import implement.implementation;
import interfaces.interfaces;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		PreparedStatement ps, ps1;
		ResultSet rs;
		Connection con;
Part part;
		FilePart filepart;
		ParamPart parampart;
		String filename = null;
String title = "";
String filetype = "";
long size=0;
String Company1="";
		String Company="";
long Totalspace=0;
long usages=0;
long full=0;
String realpath = getServletContext().getRealPath("/");
System.out.println("realpath="+realpath);
String Originalpath = realpath.substring(0, realpath.indexOf("."))
+ "HybridCloud\\WebContent\\local\\";
System.out.println("original"+Originalpath);
ArrayList<String> paramValues = new ArrayList<String>();
MultipartParser mpp = new MultipartParser(request, 999999999);
while ((part = mpp.readNextPart()) != null) {
if (part.isParam()) {
System.out.println("comming....");
parampart = (ParamPart) part;
title = parampart.getStringValue();
System.out.println("title" + title);
paramValues.add(title);
}
else if (part.isFile()) {
try {
Company=paramValues.get(0);
System.out.println("Company="+Company);
con = Connections.con();
String query = "SELECT company,totalspace,usages FROM `itjcc29`.`hybridmain` where company='"+Company+"'";
ps = con.prepareStatement(query);
rs = ps.executeQuery();
rs.next();				
Company1=rs.getStringSystem.out.println("Company1="+Company1);
Totalspace=rs.getLong(2);
System.out.println("Totalspace="+Totalspace);
usages=rs.getLong(3);
System.out.println("usages="+usages);
filepart = (FilePart) part;
filename = filepart.getFileName();
System.out.println("filename"+filename);
filetype = filepart.getContentType();
System.out.println("filetype"+filetype);
Originalpath = Originalpath + filename;
System.out.println("Originalpath"+Originalpath);
File file = new File(Originalpath);
System.out.println("file"+file);
size = filepart.writeTo(file);
System.out.println("long size"+size);
}
 catch (Exception e) {
// TODO Auto-generated catch blocke.printStackTrace();
}
}
}
System.out.println("Company.equalsIgnoreCase(Company1)"+Company.equalsIgnoreCase(Company1));
if(Company.equalsIgnoreCase(Company1)){
System.out.println("Cominggggggggggg111111111");
full=usages+size;
System.out.println("Full="+full);
if(Totalspace>=full)
System.out.println(paramValues);
UploadBean ub=new UploadBean();
ub.setCompany(paramValues.get(0));
ub.setFilename(filename);
ub.setFiletype(filetype);
ub.setFilesize(size);
interfaces ifs=new implementation();
int i=ifs.upload(ub);
System.out.println("iiiiiiiiiiiiiii="+i);
if (i==1) {
response.sendRedirect("uploadsuccess.jsp");
} 
else 
{
response.sendRedirect("error.jsp");
}
}
else 
{
response.sendRedirect("error.jsp");
}
}
else 
{
response.sendRedirect("error.jsp");
}
}
}
