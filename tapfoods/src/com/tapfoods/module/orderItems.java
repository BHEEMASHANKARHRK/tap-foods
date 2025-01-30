package com.tapfoods.module;

public class orderItems {
	int orderItemId;
	int userid;
	int menuid;
	String itemname;
	float rating;
	int quantity;
	float price;
	
	public orderItems()
	{
		
	}

	public orderItems(int orderItemId, int userid, int menuid, String itemname, float rating, int quantity,
			float price) {
		super();
		this.orderItemId = orderItemId;
		this.userid = userid;
		this.menuid = menuid;
		this.itemname = itemname;
		this.rating = rating;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	
}
