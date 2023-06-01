package servlet_work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/RemoveUser")
public class UserRemove extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ragistration", "root", "7262");
			PreparedStatement ps=con.prepareStatement("delete from user where email=?");
			ps.setString(1, email);
			
			ps.executeUpdate();
			RequestDispatcher rd=req.getRequestDispatcher("Successful.html");
			rd.include(req, res);
			pw.print("<h1>Removed Succefully</h1>");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}

}
