package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class readrecord extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root","@Tamil9988");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from Employee");
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");

			out.print("<h3>");
			while(rs.next())
			{
				out.println(rs.getInt(1)+" : "+rs.getString(2)+ " : "+rs.getString(3)+" : "+rs.getString(4)+ " : "+rs.getString(5));
				out.print("<br>");
			}
			out.print("<a href='Home.html'>Home PAGE </a>");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}