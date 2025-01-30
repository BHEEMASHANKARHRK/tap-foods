package com.tapfoods.module;

public class menu {
	int menuid;
	String name;
	float price;
	String decription;
	String imagepath;
	boolean isAvailable;
	int restavrantid;
	float rating;
	
	public menu()
	{
		
	}

	public menu(int menuid, String name, float price, String decription, String imagepath, boolean isAvailable,
			int restavrantid, float rating) {
		super();
		this.menuid = menuid;
		this.name = name;
		this.price = price;
		this.decription = decription;
		this.imagepath = imagepath;
		this.isAvailable = isAvailable;
		this.restavrantid = restavrantid;
		this.rating = rating;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRestavrantid() {
		return restavrantid;
	}

	public void setRestavrantid(int restavrantid) {
		this.restavrantid = restavrantid;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
