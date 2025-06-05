<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>All Employee Records</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

  <h2 class="header-title">All Employee Records</h2>

  <table class="employee-table">
    <thead>
      <tr>
        <th>UID</th>
        <th>UNAME</th>
        <th>SALARY</th>
        <th>AGE</th>
        <th>DESIGNATION</th>
      </tr>
    </thead>
    <tbody>
      <%
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "@Tamil9988");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;
      %>
                <tr>
                    <td><%= rs.getInt("uid") %></td>
                    <td><%= rs.getString("uname") %></td>
                    <td><%= rs.getString("salary") %></td>
                    <td><%= rs.getInt("age") %></td>
                    <td><%= rs.getString("desig") %></td>
                </tr>
      <%
            }

            if (!hasData) {
      %>
                <tr><td colspan="5" class="no-records">No Records Found</td></tr>
      <%
            }

            con.close();
        } catch (Exception e) {
      %>
          <tr><td colspan="5" class="error-text">Error: <%= e.getMessage() %></td></tr>
      <%
        }
      %>
    </tbody>
  </table>

  

</body>
</html>
