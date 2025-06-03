package com;
import java.sql.*;
public class ReadRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//Step 1: Load the JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded...!");
			// Step 2: Establish a Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HW","root","@Tamil9988");
			System.out.println("Connection is okay!");
			//Step 3: Create a Statement
			Statement stmt=con.createStatement();
			//Step 4: Execute a Query
			ResultSet rs=stmt.executeQuery("Select * from Employee");
			
			
			//optional 
			ResultSetMetaData rstmd=rs.getMetaData();
			int columnsNumber = rstmd.getColumnCount();
			System.out.println("Column Number: " + columnsNumber);
			System.out.println("1st Column name :"+rstmd.getColumnName(1)); 
			System.out.println("Type of column 1 :" + rstmd.getColumnTypeName(1));
			System.out.println("Precesion : " + rstmd.getPrecision(1));
	
		
			//u can give parameter number or column name in database
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getInt("Age")+" : "+rs.getInt("Salary")+" : "+rs.getString(5));
			}
			System.out.println("Data read successfully....!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
