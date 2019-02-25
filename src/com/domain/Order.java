package com.domain;

public class Order {
	//double amount,char paymeny,String receive,String province,String city,String county,String address,String zipCode,String telphone,String userId
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
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, String date, double amount, String paument,
			String receiver, String province, String city, String county,
			String address, String zipCode, String telphone, String userId) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.amount = amount;
		this.payment = paument;
		this.receiver = receiver;
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.zipCode = zipCode;
		this.telphone = telphone;
		this.userId = userId;
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
	public String getPaument() {
		return payment;
	}
	public void setPaument(String paument) {
		this.payment = paument;
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
	
}
