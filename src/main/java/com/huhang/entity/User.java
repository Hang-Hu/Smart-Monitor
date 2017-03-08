package com.huhang.entity;

public class User {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean validate(){
		if(("archiLab".equals(name))&&("123").equals(password)){
			return true;
		}
		else
			return false;
	}
	
}
