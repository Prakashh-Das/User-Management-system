package servlet_work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserRegister")
public class work extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException
	{
		//Fetching data from request
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String age=req.getParameter("age");
		String gender=req.getParameter("sex");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		String password=req.getParameter("pw");
		
		//Insert user entered data to database
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ragistration", "root", "7262");
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, age);      
			ps.setString(5, gender);
			ps.setString(6, address);
			ps.setString(7, password);
			
			ps.executeUpdate();
			
			RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
			rd.forward(req, res);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//Print data on web page
//		PrintWriter pw = res.getWriter();
//		res.setContentType("text/html");
//		pw.print("<html><body style='font-size: 30px;font-family: Arial;'>");
//		pw.print("WELCOME  "+name+"<br><br>");
//		pw.print("Email  : "+email+"<br>");
//		pw.print("Age    : "+age+"<br>");
//		pw.print("Gender : "+gender+"<br>");
//		pw.print("Address: "+address+"<br>");
//		pw.print("Phone  : "+phone+"<br>");
//		pw.print("Password  : "+password+"<br>");
//		pw.print("</html></body>");
	}
}
