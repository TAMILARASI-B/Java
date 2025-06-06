package com;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertRecord {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
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
            sc.close();
            
		} 
        catch (Exception e) {
			System.out.println(e);
		}
      
	}

}
