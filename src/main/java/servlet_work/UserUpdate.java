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

@SuppressWarnings("serial")
@WebServlet("/UpdateUser")
public class UserUpdate extends GenericServlet
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
			PreparedStatement ps=con.prepareStatement("select * from user where email=?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			pw.print("<html>\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"ISO-8859-1\">\r\n"
					+ "    <title>User register</title>\r\n"
					+ "    <style>\r\n"
					+ "        .box {\r\n"
					+ "            display: flex;\r\n"
					+ "            justify-content: center;\r\n"
					+ "            text-align: right;\r\n"
					+ "            font-family: Arial, Helvetica, sans-serif;\r\n"
					+ "            font-weight: bold;\r\n"
					+ "        }\r\n"
					+ "        .box h1 {\r\n"
					+ "            margin: 120px 0px 50px;\r\n"
					+ "            font-size: 37px;\r\n"
					+ "            text-align:center;\r\n"
					+ "        }\r\n"
					+ "        input{\r\n"
					+ "            width: 300px;\r\n"
					+ "            height: 30px;\r\n"
					+ "            margin: 5px;\r\n"
					+ "        }\r\n"
					+ "        input[type=\"radio\"]{\r\n"
					+ "            width: 40px;\r\n"
					+ "            height: 20px;\r\n"
					+ "            margin: 5px 0px 18px 20px;\r\n"
					+ "        }\r\n"
					+ "        input[type=\"submit\"]{\r\n"
					+ "            width: 390px;\r\n"
					+ "            height: 40px;\r\n"
					+ "            margin: 40px 5px;\r\n"
					+ "            border: none;\r\n"
					+ "            font-size: 22px;\r\n"
					+ "            background-color: grey;\r\n"
					+ "            color: white;\r\n"
					+ "        }\r\n"
					+ "        input[type=\"submit\"]:hover{\r\n"
					+ "            background-color: black;\r\n"
					+ "        }\r\n"
					+ "        .h-link {\r\n"
					+ "        	font-family: Arial, Helvetica, sans-serif;\r\n"
					+ "            display: flex;\r\n"
					+ "            justify-content: center;\r\n"
					+ "            text-decoration:none;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <div class=\"box\">\r\n"
					+ "        <form action=\"UpdateUser2\">\r\n"
					+ "            <h1>UPDATE DETAILS</h1>");
			while(rs.next())
			{
				pw.print("Name : <input type='text' name='name' value='"+rs.getString(1)+"'><br>\r\n"
						+ "    Email : <input type='email' name='email' value='"+rs.getString(2)+"'><br>\r\n"
						+ "    Phone : <input type='number' name='phone' value='"+rs.getString(3)+"'><br>\r\n"
						+ "    Age : <input type='number' name='age' value='"+rs.getInt(4)+"'><br>\r\n"
						+ "    Address : <input type='text' name='address' value='"+rs.getString(6)+"'><br>\r\n"
						+ "    Password : <input type='password' name='pw' value='"+rs.getString(7)+"'><br>\r\n"
						+ "    Gender : <input type='radio' name='sex' value='Male'>Male<input type='radio' name='sex' value='Female'>Female<input type='radio' name='sex' value='Other'>Other&nbsp;<br>\r\n"
						+ "    <input type='submit'>");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
