package com;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Login extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("uname");
    String pass = request.getParameter("upass");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    if ("Anu".equalsIgnoreCase(name) && "hello".equalsIgnoreCase(pass)) {
      RequestDispatcher rd = request.getRequestDispatcher("Home.html");
      rd.forward(request, response);
    } else {
      out.println("<div class='error-msg'>Invalid Username or Password</div>");
      RequestDispatcher rd = request.getRequestDispatcher("Login.html");
      rd.include(request, response);
    }
  }
}