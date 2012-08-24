package com.example.dbdemo;

public class POJO {

	public POJO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	private String username;
	public String getUsername() {
		return username;
	}
	private String password;
	public String getPassword() {
		return password;
	}
}
