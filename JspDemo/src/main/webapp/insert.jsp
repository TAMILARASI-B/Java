<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert Employee</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%
    String uid = request.getParameter("uid");
    String uname = request.getParameter("uname");
    String salary = request.getParameter("salary");
    String age = request.getParameter("age");
    String desig = request.getParameter("desig");

    if (uid != null && uname != null && salary != null && age != null && desig != null) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "@Tamil9988");
            PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, uid);
            ps.setString(2, uname);
            ps.setString(3, salary);
            ps.setString(4, age);
            ps.setString(5, desig);
            int rows = ps.executeUpdate();
            con.close();
%>
            <div class="message-card success">
                <h2>Employee Inserted Successfully</h2>
                <p>UID: <%= uid %></p>
              
            </div>
<%
        } catch (Exception e) {
%>
            <div class="message-card error">
                <h2>Error Inserting Record</h2>
                <p><%= e.getMessage() %></p>
                
            </div>
<%
        }
    } else {
%>
        <div class="message-card error">
            <h2>Missing Input</h2>
            <p>All fields are required.</p>
            
        </div>
<%
    }
%>

</body>
</html>
