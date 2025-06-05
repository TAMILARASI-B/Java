package com;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Insert extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int uid = Integer.parseInt(request.getParameter("uid"));
    String uname = request.getParameter("uname");
    int uage = Integer.parseInt(request.getParameter("uage"));
    int usalary = Integer.parseInt(request.getParameter("usalary"));
    String udesig = request.getParameter("udesig");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "@Tamil9988");
      PreparedStatement ps = con.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?, ?)");
      ps.setInt(1, uid);
      ps.setString(2, uname);
      ps.setInt(3, uage);
      ps.setInt(4, usalary);
      ps.setString(5, udesig);
      ps.executeUpdate();
      out.println("<!DOCTYPE html><html><head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>Insert Success</title>");
      out.println("<link rel='stylesheet' href='style.css'>");
      out.println("</head><body>");

      out.println("<div class='message-card success'>");
      out.println("<h2>Record Inserted Successfully</h2>");
      out.println("<a href='Home.html' class='btn'>Back to Home</a>");
      out.println("</div>");

      out.println("</body></html>");

    } catch (Exception e) {
      out.println("<div class='error-msg'>Error: " + e.getMessage() + "</div>");
    }
  }
}