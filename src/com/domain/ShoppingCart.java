package com.domain;

import java.io.Serializable;

public class ShoppingCart implements Serializable{
	private int shoppingCartId;
	private Product product;
	private int quantity;
	private String userId;
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(int shoppingCartId, Product product, int quantity,
			String userId) {
		super();
		this.shoppingCartId = shoppingCartId;
		this.product = product;
		this.quantity = quantity;
		this.userId = userId;
	}
	public int getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
