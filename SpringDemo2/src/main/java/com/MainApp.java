package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");

		// Get the bean from Spring container
		Employee e = (Employee) context.getBean("empbean");

		// Print and call method
		System.out.println(e);
		System.out.println("*********************** ARRAYS *******************");
		String hob[] = e.getHobbies();

		for (String hb : hob) {
			System.out.println("- " + hb);
		}
		System.out.println("*********************** LIST *******************");
		ArrayList<String> emails = e.getEmails();
        Iterator<String> emailIterator = emails.iterator();
        while (emailIterator.hasNext()) {
            System.out.println("- " + emailIterator.next());
        }

        // Iterator for PANs
        System.out.println("****************** PAN ***********************");
        HashSet<String> opan = e.getPan();
        Iterator<String> panIterator = opan.iterator();
        while (panIterator.hasNext()) {
            System.out.println("- " + panIterator.next());
        }

	}

}