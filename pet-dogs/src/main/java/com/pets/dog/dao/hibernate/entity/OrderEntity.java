package com.pets.dog.dao.hibernate.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_tbl")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderNumber;

	private Date orderDate;
	
	@Column (name = "first_name", nullable = false)
	private String firstName;
	
	@Column (name = "last_name", nullable = false)
	private String lastName;
	
	@Column (name = "email", nullable = false)
	private String email;

	private String destinationAddress;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<OrderDetailsEntity> orderDetails;//Is this annotation right?
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public List<OrderDetailsEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderNumber=" + orderNumber + ", orderDate="
				+ orderDate + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", destinationAddress="
				+ destinationAddress + ", orderDetails=" + orderDetails + "]";
	}
	
	
}
