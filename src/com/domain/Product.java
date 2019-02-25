package com.domain;

import java.io.Serializable;

public class Product implements Serializable{
	private int productId;
	private String description;
	private double price;
	private String model;
	private String feature;
	private String imgpath;
	private int novaltyStatus;
	private String publishDate;
	private int categoryId;
	private String name;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String description, double price,
			String model, String feature, String imgpath, int novaltyStatus,
			String publishDate, int categoryId) {
		super();
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.model = model;
		this.feature = feature;
		this.imgpath = imgpath;
		this.novaltyStatus = novaltyStatus;
		this.publishDate = publishDate;
		this.categoryId = categoryId;
	}

	public Product(int productId, String description, double price,
			String model, String feature, String imgpath, int novaltyStatus,
			String publishDate, int categoryId, String name) {
		super();
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.model = model;
		this.feature = feature;
		this.imgpath = imgpath;
		this.novaltyStatus = novaltyStatus;
		this.publishDate = publishDate;
		this.categoryId = categoryId;
		this.name = name;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public int getNovaltyStatus() {
		return novaltyStatus;
	}

	public void setNovaltyStatus(int novaltyStatus) {
		this.novaltyStatus = novaltyStatus;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	

}
