package com;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * Default constructor. 
     */
    public Insert() {
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		String uname=request.getParameter("uname");
		int uage=Integer.parseInt(request.getParameter("uage"));
		int usalary=Integer.parseInt(request.getParameter("usalary"));
		String udesig=request.getParameter("udesig");
		System.out.println("My name is :"+uname);
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root","@Tamil9988");
			PreparedStatement pstmt=con.prepareStatement("insert into EMployee values(?,?,?,?,?)");
			pstmt.setInt(1, uid);
			pstmt.setString(2, uname);
			pstmt.setInt(3, uage);
			pstmt.setInt(4,usalary);
			pstmt.setString(5, udesig);
 
			pstmt.execute();
			pstmt.close();
			con.close();
			System.out.println("Data Inserted successfully....!");
			}
			catch (Exception e) {
				System.out.println(e);
			}
		out.print("<h1>");
		out.print("You are successfully Registerd :"+uname);
		out.print("<br>");
		out.print("<h1>");
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
 
}