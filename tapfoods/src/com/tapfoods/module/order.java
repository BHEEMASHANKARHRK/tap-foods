package com.tapfoods.module;

public class order {
	
	int orderid;
	int restavrantid_ch;
	int userid;
	float totalAmount;
	String modeOfPayment;
	String status;
	
	public order()
	{
		
	}

	public order(int orderid, int restavrantid_ch, int userid, float totalAmount, String modeOfPayment, String status) {
		super();
		this.orderid = orderid;
		this.restavrantid_ch = restavrantid_ch;
		this.userid = userid;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getRestavrantid_ch() {
		return restavrantid_ch;
	}

	public void setRestavrantid_ch(int restavrantid_ch) {
		this.restavrantid_ch = restavrantid_ch;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
