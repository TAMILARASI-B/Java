package com;

import java.util.*;

public class Employee {
	private int uid;
	private String name;
	private String city;
	private int ph;
	public String hobbies[];
	public ArrayList emails;
	public HashSet pan;
	public ArrayList getEmails() {
		return emails;
	}
	public void setEmails(ArrayList emails) {
		this.emails = emails;
	}
	public HashSet getPan() {
		return pan;
	}
	public void setPan(HashSet pan) {
		this.pan = pan;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
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
	}
	@Override
	public String toString() {
	    return "Employee [uid=" + uid + ", name=" + name + ", city=" + city + ", ph=" + ph + "]";
	}
}