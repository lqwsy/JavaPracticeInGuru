package com.guru.practice;

import java.io.Serializable;

public class Employee implements Cloneable,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	private int age;
	private double salary;
	
	public Employee() {
	}
	public Employee(String name) {
		this.name = name;
	}
	public Employee(String name,int age,double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
