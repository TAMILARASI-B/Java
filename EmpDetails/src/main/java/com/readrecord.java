package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Readrecord")
public class readrecord extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String jdbcURL = "jdbc:mysql://localhost:3306/HW";
        String dbUser = "root";
        String dbPass = "@Tamil9988";

        out.println("<!DOCTYPE html><html><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>All Employee Records</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head><body>");

        try {
            // ✅ Explicitly load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPass)) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

                out.println("<div class='display-container'>");
                out.println("<h2>Employee Records</h2>");
                out.println("<table class='styled-table'>");
                out.println("<thead><tr><th>ID</th><th>Name</th><th>Age</th><th>Salary</th><th>Designation</th></tr></thead>");
                out.println("<tbody>");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("uid") + "</td>");
                    out.println("<td>" + rs.getString("uname") + "</td>");
                    out.println("<td>" + rs.getInt("age") + "</td>");
                    out.println("<td>" + rs.getDouble("salary") + "</td>");
                    out.println("<td>" + rs.getString("desig") + "</td>");
                    out.println("</tr>");
                }

                out.println("</tbody></table>");
                out.println("<a href='Home.html' class='btn'>Back to Home</a>");
                out.println("</div>");
            }

        } catch (ClassNotFoundException e) {
            out.println("<div class='message-card error'><h2>Driver Error</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='Home.html' class='btn'>Back to Home</a></div>");
        } catch (SQLException e) {
            out.println("<div class='message-card error'><h2>Error Fetching Records</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='Home.html' class='btn'>Back to Home</a></div>");
        }

        out.println("</body></html>");
    }
}
