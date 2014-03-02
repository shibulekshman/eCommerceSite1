package com.pets.dog.dao.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="contact_Us_tbl")
public class ContactUsEntity {
	
	private int cfid;
	private String name;
	private String email;
	private String mobileNumber;
	private String purpose;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
	@Override
	public String toString() {
		return "ContactUsEntity [cfid=" + cfid + ", name=" + name + ", email="
				+ email + ", mobileNumber=" + mobileNumber + ", purpose="
				+ purpose + "]";
	}
	
	
	
}
