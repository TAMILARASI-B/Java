<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Delete Employee</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%
    String uid = request.getParameter("uid");

    if (uid != null) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "@Tamil9988");
            PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE uid = ?");
            ps.setString(1, uid);
            int rows = ps.executeUpdate();
            con.close();
%>
            <div class="message-card success">
                <h2>Record Deleted Successfully</h2>
                <p>for UID: <%= uid %></p>
               
            </div>
<%
        } catch (Exception e) {
%>
            <div class="message-card error">
                <h2>Error Deleting Record</h2>
                <p><%= e.getMessage() %></p>
                
            </div>
<%
        }
    } else {
%>
        <div class="message-card error">
            <h2>Invalid UID</h2>
            <p>Please provide a valid UID to delete.</p>
            
        </div>
<%
    }
%>

</body>
</html>
