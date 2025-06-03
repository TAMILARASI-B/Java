package com;

import java.sql.*;

public class Demo1 {

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
			stmt.execute("Insert into Employee value(111,'Thanesh',28,90000,'Developer')");
			//Step 5: Close the Connection
			stmt.close();
			con.close();
			System.out.println("Data are Inserted....!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
