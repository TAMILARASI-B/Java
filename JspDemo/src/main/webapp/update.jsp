<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Update Employee Salary</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%
    String uid = request.getParameter("uid");
    String usalary = request.getParameter("usalary");

    if (uid != null && usalary != null) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "@Tamil9988");
            PreparedStatement ps = con.prepareStatement("UPDATE employee SET salary = ? WHERE uid = ?");
            ps.setString(1, usalary);
            ps.setString(2, uid);
            int rows = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            out.println("<h2 style='color:red;'>Error: " + e.getMessage() + "</h2>");
        }
    } else {
        out.println("<h2 style='color:red;'>Please enter both UID and Salary.</h2>");
    }
%>
<div class="message-card">
    <h2>Salary Updated Successfully</h2>
    <p>for UID: <%= request.getParameter("uid") %></p>
  

</div>


</body>
</html>
