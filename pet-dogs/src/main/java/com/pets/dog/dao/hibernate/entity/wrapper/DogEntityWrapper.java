package com.pets.dog.dao.hibernate.entity.wrapper;

import java.util.List;

import com.pets.dog.dao.hibernate.entity.DogEntity;

public class DogEntityWrapper {
	
	private List<DogEntity> dogEntities;
	private boolean isIndexChanged=true;
	private int totalPages;
	
	private int totalCount;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	

	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<DogEntity> getDogEntities() {
		return dogEntities;
	}
	public void setDogEntities(List<DogEntity> dogEntities) {
		this.dogEntities = dogEntities;
	}
	public boolean isIndexChanged() {
		return isIndexChanged;
	}
	public void setIndexChanged(boolean isIndexChanged) {
		this.isIndexChanged = isIndexChanged;
	}

}
