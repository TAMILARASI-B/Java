package com;
import java.sql.*;
import java.util.*;
public class Demo2 {

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
			// Step 3:Create prepared statement for Instead of hard coding queries, Set parameter placeholders(use question mark for placeholders)
			PreparedStatement stmt=con.prepareStatement("Insert into Employee values(?,?,?,?,?)");
			// Step 4:Get input from user
			Scanner sc=new Scanner(System.in); 
			System.out.println("Enter ID: ");int sid=sc.nextInt();
			System.out.println("Enter Name: ");String name=sc.next();
			System.out.println("Enter Age: ");int age=sc.nextInt();
			System.out.println("Enter Salary: ");int salary=sc.nextInt();
			System.out.println("Enter Desig: ");String desig=sc.next();
			//Step 5: Set parameter values for type and position
			stmt.setInt(1, sid);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setInt(4, salary);
			stmt.setString(5, desig);
			//Step 6: Execute a Query
			stmt.execute();
			//Step 7: Close the Connection
			stmt.close();
			con.close();
			sc.close();
			System.out.println("Datas are inserted...!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
