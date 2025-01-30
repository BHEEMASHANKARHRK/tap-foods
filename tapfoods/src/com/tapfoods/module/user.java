package com.tapfoods.module;

import java.sql.Date;
import java.util.*;

public class user {
	
	private int userid;
	private String name;
	private String email;
	private int phoneno;
	private String address;
	private String username;
	private String password;
	private String role;
	
	public user()
	{
		
	}
	public user(int userid, String name, String email, int phoneno, String address, String username, String password,
			String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.address = address;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
