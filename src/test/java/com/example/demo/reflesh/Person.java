package com.example.demo.reflesh;

public class Person {
	
	private String user;
	private String pass;
	private int age;
	
	public Person(String user, String pass, int age) {
		super();
		this.user = user;
		this.pass = pass;
		this.age = age;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
