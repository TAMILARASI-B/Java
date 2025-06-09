package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e1=(Employee)context.getBean("empbean");
		Employee e2=(Employee)context.getBean("empbean");
		Employee e3=(Employee)context.getBean("empbean");
		

	}

}
