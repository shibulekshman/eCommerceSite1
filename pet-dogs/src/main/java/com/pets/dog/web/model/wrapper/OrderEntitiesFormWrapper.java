package com.pets.dog.web.model.wrapper;

import java.util.List;

import com.pets.dog.dao.hibernate.entity.OrderEntity;

public class OrderEntitiesFormWrapper {

	private List<OrderEntity> orderEntities;
	private int countOfEntities;

	public List<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(List<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

	public int getCountOfEntities() {
		return countOfEntities;
	}

	public void setCountOfEntities(int countOfEntities) {
		this.countOfEntities = countOfEntities;
	}

	@Override
	public String toString() {
		return "OrderEntitiesFormWrapper [orderEntities=" + orderEntities
				+ ", countOfEntities=" + countOfEntities + "]";
	}
	
	
}
