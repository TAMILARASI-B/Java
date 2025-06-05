
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <!-- your content here -->
    <%@ page import="javax.servlet.*,javax.servlet.http.*,java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("uname");
    String pass = request.getParameter("upass");

    if (name != null && pass != null) {
        if ("Anu".equalsIgnoreCase(name) && "hello".equalsIgnoreCase(pass)) {
            response.sendRedirect("Home.html");
        } else {
%>
            <div class="error-msg">Invalid Username or Password</div>
            <jsp:include page="login.html" />
<%
        }
    }
%>
    
</body>
</html>
