package com.domain;

public class OrderDetail {

	private int orderId;
	private String date;
	private double amount;
	private String payment;
	private String receiver;
	private String province;
	private String city;
	private String county;
	private String address;
	private String zipCode;
	private String telphone;
	private String userId;
	private String productId;
	private String description;
	private int quantity;
	private double price;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int orderId, String date, double amount, String payment,
			String receiver, String province, String city, String county,
			String address, String zipCode, String telphone, String userId,
			String productId, String description, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.amount = amount;
		this.payment = payment;
		this.receiver = receiver;
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.zipCode = zipCode;
		this.telphone = telphone;
		this.userId = userId;
		this.productId = productId;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
