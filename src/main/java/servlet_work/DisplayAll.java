package servlet_work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/viewAll")
public class DisplayAll extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ragistration", "root", "7262");
			PreparedStatement ps=con.prepareStatement("select * from user");
			
			ResultSet rs = ps.executeQuery();
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.print("<html>\r\n"
					+ "    <head>\r\n"
					+ "        <style>\r\n"
					+ "            body{\r\n"
					+ "                display: flex;\r\n"
					+ "                justify-content: center;\r\n"
					+ "                font-family: Arial, Helvetica, sans-serif;\r\n"
					+ "            }\r\n"
					+ "            h1{\r\n"
					+ "                margin: 120px 0px 100px;\r\n"
					+ "                font-size: 37px;\r\n"
					+ "                text-align:center;\r\n"
					+ "            }\r\n"
					+ "        </style>\r\n"
					+ "    </head>\r\n"
					+ "    <body>\r\n"
					+ "        <div>\r\n"
					+ "            <h1>All users</h1>\r\n"
					+ "            <table cellpadding=\"15px\">\r\n"
					+ "                <thead style=\"background-color: rgb(112, 112, 112);color: white;\">\r\n"
					+ "                    <th>Name</th>\r\n"
					+ "                    <th>Email</th>\r\n"
					+ "                    <th>Phone</th>\r\n"
					+ "                    <th>Age</th>\r\n"
					+ "                    <th>Gender</th>\r\n"
					+ "                    <th>Address</th>\r\n"
					+ "                </thead>\r\n"
					+ "                <tbody>");
			
			while(rs.next())
			{
				pw.print("<tr>\r\n"
						+ "                        <td>"+rs.getString(1)+"</td>\r\n"
						+ "                        <td>"+rs.getString(2)+"</td>\r\n"
						+ "                        <td>"+rs.getString(3)+"</td>\r\n"
						+ "                        <td>"+rs.getInt(4)+"</td>\r\n"
						+ "                        <td>"+rs.getString(5)+"</td>\r\n"
						+ "                        <td>"+rs.getString(6)+"</td>\r\n"
						+ "                    </tr>");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}

}
