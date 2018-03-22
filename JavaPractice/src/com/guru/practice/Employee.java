package com.guru.practice;

import java.io.Serializable;

public class Employee implements Cloneable,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	protected int age;
	private double salary;
	
	public Employee() {
		System.out.println("无参构造方法");
	}
	public Employee(String name) {
		this.name = name;
		System.out.println("姓名构造方法");
	}
	public Employee(String name,int age,double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		System.out.println("详细构造方法");
	}
	private Employee(int age){
		System.out.println("私有构造方法");
	}
	protected Employee(String name,int salary){
		System.out.println("保护构造方法");
	}
	
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		System.out.println("调用getName方法");
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
