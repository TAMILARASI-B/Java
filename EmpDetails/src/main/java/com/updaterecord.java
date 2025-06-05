package com;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updaterecord extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uid = request.getParameter("uid");
    String usalary = request.getParameter("usalary");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "@Tamil9988");
      PreparedStatement ps = con.prepareStatement("UPDATE Employee SET salary = ? WHERE uid = ?");
      ps.setString(1, usalary);
      ps.setString(2, uid);
      ps.executeUpdate();
      out.println("<!DOCTYPE html><html><head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>Update Success</title>");
      out.println("<link rel='stylesheet' href='style.css'>");
      out.println("</head><body>");

      out.println("<div class='message-card success'>");
      out.println("<h2>Salary Updated Successfully</h2>");
      out.println("<a href='Home.html' class='btn'>Back to Home</a>");
      out.println("</div>");

      out.println("</body></html>");
    } catch (Exception e) {
      out.println("<div class='error-msg'>Error: " + e.getMessage() + "</div>");
    }
  }
}
