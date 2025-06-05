<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <!-- your content here -->
    
<%
    String user = (String) session.getAttribute("username");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<h2>Welcome, <%= user %>!</h2>
<a href="insert.jsp">Insert Employee</a><br/>
<a href="update.jsp">Update Employee</a><br/>
<a href="delete.jsp">Delete Employee</a><br/>
<a href="display.jsp">Display Employees</a><br/>
<a href="logout.jsp">Logout</a>
    
</body>
</html>
