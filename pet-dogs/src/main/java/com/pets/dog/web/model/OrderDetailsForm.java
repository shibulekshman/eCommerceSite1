package com.pets.dog.web.model;

import com.pets.dog.dao.hibernate.entity.DogEntity;

public class OrderDetailsForm {
	
private int orderDetailsId;
	
	private DogEntity dogEntity;
	
	private String orderStatus; 

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public DogEntity getDogEntity() {
		return dogEntity;
	}

	public void setDogEntity(DogEntity dogEntity) {
		this.dogEntity = dogEntity;
	}



}
