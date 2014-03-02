package com.pets.dog.dao.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details_tbl")
public class OrderDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderDetailsId;
	
	
	private String orderStatus; //I intend to use the OrderStatus interface's constants here, but can we use enumerations here? 
	//Is it because enumerations are internally stored as integers and not as Strings and in the database the value will be integer?

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


	

}
