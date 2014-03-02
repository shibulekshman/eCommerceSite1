package com.pets.dog.dao.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdministratorEntity {
	
	@Id
	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdministratorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdministratorEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
