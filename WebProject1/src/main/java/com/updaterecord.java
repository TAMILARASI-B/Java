package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updaterecord extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=  request.getParameter("uid");
		
		String usalary= request.getParameter("usalary");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root","@Tamil9988");

			
			PreparedStatement pstmt=con.prepareStatement("update Employee set salary= ? where uid= ?");
			
			pstmt.setString(1, usalary);
			pstmt.setString(2, uid);
			
			pstmt.execute();
			pstmt.close();
			con.close();
			
			PrintWriter out=response.getWriter();
			out.print("<h1> Data Updated Successfully");
			System.out.println("Data Updated successfully....!");
			out.print("<br><a href='Home.html'>Home PAGE </a>");
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}


}