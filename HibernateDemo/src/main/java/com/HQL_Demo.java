package com;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
 
public class HQL_Demo {
 
    public static void main(String[] args) {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
 
        // 1. Select all employees
        System.out.println("1. All Employees:");
        List<Employee> allEmployees = session.createQuery("FROM Employee", Employee.class).list();
        for (Employee e : allEmployees) {
            System.out.println(e);
        }
 
        // 2. Employees from a specific city
        System.out.println("\n2. Employees from Pune:");
        List<Employee> cityEmployees = session.createQuery("FROM Employee WHERE city = 'Pune'", Employee.class).list();
        for (Employee e : cityEmployees) {
            System.out.println(e);
        }
 
        // 3. Employee by username
        System.out.println("\n3. Employee with username 'Diya':");
        List<Employee> userEmployee = session.createQuery("FROM Employee WHERE username = 'shreetharan'", Employee.class).list();
        for (Employee e : userEmployee) {
            System.out.println(e);
        }
 
        // 4. Employees with PIN > 600000
        System.out.println("\n4. Employees with PIN > 60000:");
        List<Employee> pinEmployees = session.createQuery("FROM Employee WHERE pin > 600000", Employee.class).list();
        for (Employee e : pinEmployees) {
            System.out.println(e);
        }
 
        // 5. Select only city and pin
        System.out.println("\n5. Cities and PINs:");
        List<Object[]> cityPins = session.createQuery("SELECT e.city, e.pin FROM Employee e").list();
        for (Object[] row : cityPins) {
            System.out.println("City: " + row[0] + ", PIN: " + row[1]);
        }
 
        tx.commit();
        session.close();
        factory.close();
    }
}