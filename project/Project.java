package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
 
class Employee
{
	public Employee() {
		System.out.println("HI EMployee Project");
	}
	static void insert() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // we are using the mysql ...!
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "@Tamil9988");
			System.out.println("Connection is okay...!");
			PreparedStatement stmt= con.prepareStatement("insert into student values(?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("ENter ID :"); int sid = sc.nextInt();
			System.out.println("Enter name :");String name= sc.next();
			System.out.println("Enter Marks:"); int marks= sc.nextInt();
			System.out.println("Enter Phone"); int ph = sc.nextInt();
			stmt.setInt(1,sid);
			stmt.setString(2, name);
			stmt.setInt(3, marks);
			stmt.setInt(4, ph);
			stmt.execute();
			stmt.close();
			System.out.println("Data Are Inserted....!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	static void display()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // we are using the mysql ...!
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/GU", "root", "root");
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Student ");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getString(2)+ " :"+rs.getInt("Smarks") + " :"+rs.getInt("SPhone"));
				System.out.println("    ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	static void Delete()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // we are using the mysql ...!
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/GU", "root", "root");
			System.out.println("Connection is okay...!");
			PreparedStatement stmt= con.prepareStatement("delete from student where sid =?");
			Scanner sc = new Scanner(System.in);
			System.out.println("ENter ID :"); int sid = sc.nextInt();
			stmt.setInt(1,sid);
			stmt.execute();
			stmt.close();
			System.out.println("Data Are Deleted...!....!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	static void updates()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // we are using the mysql ...!
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/GU", "root", "root");
			System.out.println("Connection is okay...!");
			PreparedStatement stmt= con.prepareStatement("update student set smarks = ? where sid = ?");
			Scanner sc = new Scanner(System.in);
			System.out.println("ENter ID :"); int sid = sc.nextInt();
			System.out.println("Enter Marks:"); int marks= sc.nextInt();
			stmt.setInt(1,marks);
			stmt.setInt(2, sid);
			stmt.execute();
			stmt.close();
			System.out.println("Data Are Updated....!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
 
}
// CRUD
public class Project {
	public static void main(String[] args) {
		int ch1=0;
		do {
			System.out.println("1 ) CREATE ");
			System.out.println("2 ) READ ");
			System.out.println("3 ) Delete ");
			System.out.println("4 ) Update ");
			System.out.println("5 ) EXIT ");
			Scanner sc = new Scanner(System.in);
			 ch1=sc.nextInt();
			 if(ch1==1) {Employee.insert() ; } 
			 if(ch1==2) {Employee.display(); } 
			 if(ch1==3) {Employee.Delete(); }
			 if(ch1==4) {Employee.updates();} 
			 if(ch1==5) { 
				 System.out.println("Thank you ");
				 System.exit(0);
			 }
		} while (ch1!=5);
	}
}