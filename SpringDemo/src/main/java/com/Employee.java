package com;
 
public class Employee {
	private int uid;
	private String name;
	private String city;
	private int ph;
			// setter getter 
			// to String
/*
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}*/
	
	public Employee(int uid, String name, String city, int ph) {
		super();
		this.uid = uid;
		this.name = name;
		this.city = city;
		this.ph = ph;
	}
	@Override
	public String toString() {
		return "Employee [uid=" + uid + ", name=" + name + ", city=" + city + ", ph=" + ph + "]";
	}
	
	void display() {
		System.out.println("ID :"+ uid);
		System.out.println("name :"+name);
		System.out.println("City L"+ city);
		System.out.println("Phone :"+ ph);
	}
}