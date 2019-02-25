package com.domain;

import java.io.Serializable;

public class Tuser implements Serializable{
	private String userId;
	private String password;
	private String username;
	public Tuser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tuser(String userId, String password, String username) {
		super();
		this.userId = userId;
		this.password = password;
		this.username = username;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
