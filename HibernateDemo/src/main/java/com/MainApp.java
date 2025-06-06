
package com;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
class project
{
	static void insert()
	{
		try {
        	
        	Configuration cfg = new Configuration();
        	cfg.configure("hibernate.cfg.xml");
        	
        	//2 step 
        	SessionFactory factory = cfg.buildSessionFactory();
        	
            Employee st = new Employee();
//        	  st.setUid(100);
//              st.setName("Thanesh");
//              st.setCity("AP");
//              st.setPin(43567);
              
              
        	Scanner sc= new Scanner(System.in);
        	System.out.println("Enter ID");
        	int uid=sc.nextInt();
        	
        	System.out.println("Enter Name : ");
        	String name= sc.next();
        	
        	System.out.println("Enter City : ");
        	String city= sc.next();
        	
        	System.out.println("Enter PIN : ");
        	int  pin= sc.nextInt();
     	
           st.setId(uid);
           st.setName(name);
           st.setCity(city);
           st.setPin(pin);
           
            
            Session session = factory.openSession();
            Transaction tx  =session.beginTransaction();
            session.save(st);
            tx.commit();
            
            System.out.println("Data Inserted...!");
            
            
		} 
        catch (Exception e) {
			System.out.println(e);
		}
 
		
	}
	static void delete()
	{
try {
        	
        	Configuration cfg = new Configuration();
        	cfg.configure("hibernate.cfg.xml");
      
        	SessionFactory factory = cfg.buildSessionFactory();
        	
        	Employee st = new Employee();

                        
        	Scanner sc= new Scanner(System.in);
        	System.out.println("Enter ID to Delete : ");
        	int uid=sc.nextInt();
        	
        	st.setId(uid);
        	
            Session session = factory.openSession();
            Transaction tx  =session.beginTransaction();
            session.delete(st);
            tx.commit();
            
            System.out.println("Data Deleted Successfully ...!");
            
		} 
        catch (Exception e) {
			System.out.println(e);
		}
 

		
	}
	static void read()	
	{
		try
		{
		Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
  
    	SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx  =session.beginTransaction();
       
        List employees = session.createQuery("FROM Employee").list(); 
        for (Iterator iterator = employees.iterator();iterator.hasNext();)
        {
           Employee  employee = (Employee) iterator.next(); 
           System.out.println("ID : " + employee.getUid()); 
           System.out.println("NAME: " + employee.getName()); 
           System.out.println("CITY : " + employee.getCity()); 
           System.out.println("PIN: " + employee.getPin()); 
        }
        tx.commit();
 
        
	}
    catch (Exception e) {
		System.out.println(e);
	}

    
		
	}
	static void update()
	{
		Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
  
    	SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx  =session.beginTransaction();
	      
	      try {
	    	  Scanner sc = new Scanner(System.in);
	    	  System.out.println("Enter ID to UPDATE : ");
	    	  int id=sc.nextInt();
	    	  
	    	  System.out.println("Transfer  to  :");
	    	  String city=sc.next();

	         Employee employee = (Employee)session.get(Employee.class, id); 
	         employee.setCity( city );
	         
			 session.update(employee); 
	         tx.commit();
	         
	      } catch (Exception e) {
	       System.out.println(e);
	      }
	}
}
public class MainApp 
{
    public static void main( String[] args )
    {
          Scanner sc = new Scanner(System.in);
          int ch=0;
         do {
        	 System.out.println("1 ) INSERT ");

        	 System.out.println("2 ) DELETE ");

        	 System.out.println("3 ) READ ");

        	 System.out.println("4 ) UDPATE ");
        	 
        	 System.out.println("5 ) EXIT ");
        	 
			System.out.println("Enter the choice : ");
			ch=sc.nextInt();
			if(ch==1)
			{
				project.insert();
			}
			if(ch==2)
			{
				project.delete();
			}
			if(ch==3)
			{
				project.read();
			}
			if(ch==4)
			{
				project.update();
			}
			if(ch==5)
			{
			    System.out.println("Exiting...");
			    System.exit(0);
			}

		} while (ch<=4);
         sc.close();
    }
}
