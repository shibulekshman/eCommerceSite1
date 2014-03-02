package com.pets.dog.web.model;

public class ContactUsForm {
	
	private int cfid;
	private String name;
	private String email;
	private String mobileNumber;
	private String purpose;
	
	public int getCfid() {
		return cfid;
	}
	public void setCfid(int cfid) {
		this.cfid = cfid;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	

}
