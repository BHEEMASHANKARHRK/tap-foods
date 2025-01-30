package com.tapfoods.module;

import java.sql.Date;
import java.time.LocalDate;

public class restavrant {
	
	private int restavrantid;
	private String name;
	private String imagepath;
	private float rating;
	private int eta;
	private String cuisineType;
	private String address;
	private boolean isActive;
	private int restavrentOwnerid;
	
	public restavrant()
	{
		
	}

	public restavrant(int restavrantid, String name, String imagepath, float rating, int eta, String cuisineType,
			String address, boolean isActive, int restavrentOwnerid) {
		super();
		this.restavrantid = restavrantid;
		this.name = name;
		this.imagepath = imagepath;
		this.rating = rating;
		this.eta = eta;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restavrentOwnerid = restavrentOwnerid;
	}

	public int getRestavrantid() {
		return restavrantid;
	}

	public void setRestavrantid(int restavrantid) {
		this.restavrantid = restavrantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRestavrentOwnerid() {
		return restavrentOwnerid;
	}

	public void setRestavrentOwnerid(int restavrentOwnerid) {
		this.restavrentOwnerid = restavrentOwnerid;
	}
	
	
}
