package com.guru.practice;

public class Manager extends Employee{
	
	private String job;
	
	public Manager() {
	}
	
	public Manager(String name) {
		this.name = name;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
