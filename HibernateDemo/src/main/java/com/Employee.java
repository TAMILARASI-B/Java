package com;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="MyEmployee")
public class Employee {
	@Id
	private int uid;
	@Column(name="UserName")
	private String name;
	private String city;
	@Transient
	private int pin;
	public int getUid() {
		return uid;
	}
	public void setId(int uid) {
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
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return this.uid + " "+this.name + " : "+this.city  + " : "+this.pin;
	}	
	
}
