package com.lab3.bean;

public class User {
	protected int id;
	protected String name;
	protected String lastname;
	protected String age;
	protected String salary;
	protected String objektas;
	protected String pareigos;
	
	
	
	
	public User(String name, String lastname, String age, String salary, String objektas, String pareigos) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.salary = salary;
		this.objektas = objektas;
		this.pareigos = pareigos;
	}
	public User(int id, String name, String lastname, String age, String salary, String objektas, String pareigos) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.salary = salary;
		this.objektas = objektas;
		this.pareigos = pareigos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getObjektas() {
		return objektas;
	}
	public void setObjektas(String objektas) {
		this.objektas = objektas;
	}
	public String getPareigos() {
		return pareigos;
	}
	public void setPareigos(String pareigos) {
		this.pareigos = pareigos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
