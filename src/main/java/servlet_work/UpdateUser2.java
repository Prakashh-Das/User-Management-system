package servlet_work;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UpdateUser2")
public class UpdateUser2 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String age=req.getParameter("age");
		String gender=req.getParameter("sex");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		String password=req.getParameter("pw");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ragistration", "root", "7262");
			PreparedStatement ps=con.prepareStatement("update user set name=?,phone=?,age=?,gender=?,address=?,password=? where email=?");
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, age);
			ps.setString(4, gender);      
			ps.setString(5, address);
			ps.setString(6, password);
			ps.setString(7, email);
			
			ps.executeUpdate();
			
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			RequestDispatcher rd=req.getRequestDispatcher("Successful.html");
			rd.include(req, res);
			pw.print("<h1>Succefully updated</h1>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
