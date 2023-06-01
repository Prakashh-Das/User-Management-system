package servlet_work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserLogin")
public class LoginServlet extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		String password=req.getParameter("pw");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ragistration", "root", "7262");
			PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				RequestDispatcher rd=req.getRequestDispatcher("Home.html");
				rd.forward(req, res);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
		rd.include(req, res);
		pw.print("<br><br><br><br><br><br><center><h1 style='color:red;'>Invalid username and password</h1></center>");
	}
}
