package project;
import java.sql.*;
import java.util.*;

public class EmployeeCRUDApp {
    
    static final String URL = "jdbc:mysql://localhost:3306/HW";
    static final String USER = "root";
    static final String PASSWORD = "@Tamil9988";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to DB!");

            while (true) {
                System.out.println("\n=== Employee Management ===");
                System.out.println("1. Create");
                System.out.println("2. Display");
                System.out.println("3. Delete");
                System.out.println("4. Update");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        createEmployee(con, sc);
                        break;
                    case 2:
                        displayEmployees(con);
                        break;
                    case 3:
                        deleteEmployee(con, sc);
                        break;
                    case 4:
                        updateEmployee(con, sc);
                        break;
                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Create
    public static void createEmployee(Connection con, Scanner sc) throws SQLException {
        String query = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();
            System.out.print("Enter Designation: ");
            String desig = sc.next();

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setInt(4, salary);
            stmt.setString(5, desig);

            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee inserted successfully!");
        }
    }

    // Display
    public static void displayEmployees(Connection con) throws SQLException {
        String query = "SELECT * FROM Employee";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.printf("\n%-5s %-15s %-5s %-10s %-15s\n", "ID", "Name", "Age", "Salary", "Designation");
            System.out.println("--------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-15s %-5d %-10d %-15s\n",
                        rs.getInt("uid"),
                        rs.getString("uname"),
                        rs.getInt("age"),
                        rs.getInt("salary"),
                        rs.getString("desig"));
            }
        }
    }

    // Delete
    public static void deleteEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM Employee WHERE uid = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee deleted successfully!");
            else System.out.println("Employee not found.");
        }
    }

    // Update
    public static void updateEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();

        String checkQuery = "SELECT * FROM Employee WHERE uid = ?";
        try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Employee not found.");
                return;
            }
        }

        System.out.print("Enter new Name: ");
        String name = sc.next();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();
        System.out.print("Enter new Salary: ");
        int salary = sc.nextInt();
        System.out.print("Enter new Designation: ");
        String desig = sc.next();

        String query = "UPDATE Employee SET uname=?, age=?, salary=?, desig=? WHERE uid=?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setInt(3, salary);
            stmt.setString(4, desig);
            stmt.setInt(5, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee updated successfully!");
        }
    }
}