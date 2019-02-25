package com.domain;

import java.io.Serializable;

public class Category implements Serializable{

	private int categoryId;
	private String cname;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryId, String cname) {
		super();
		this.categoryId = categoryId;
		this.cname = cname;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
