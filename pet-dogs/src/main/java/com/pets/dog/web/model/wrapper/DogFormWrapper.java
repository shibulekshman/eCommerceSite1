package com.pets.dog.web.model.wrapper;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.pets.dog.web.model.DogForm;

/**
 * 
 * @author yadna01
 *
 */
@XmlRootElement //Why is this here? This is for the restful webservice. This is being marshalled using JaxB to send over net.
public class DogFormWrapper {
	
	private List<DogForm> dogForms;
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
	
	public List<DogForm> getDogForms() {
		return dogForms;
	}
	public void setDogForms(List<DogForm> dogForms) {
		this.dogForms = dogForms;
	}
	public boolean isIndexChanged() {
		return isIndexChanged;
	}
	public void setIndexChanged(boolean isIndexChanged) {
		this.isIndexChanged = isIndexChanged;
	}
	@Override
	public String toString() {
		return "DogFormWrapper [dogForms=" + dogForms + ", isIndexChanged="
				+ isIndexChanged + ", totalPages=" + totalPages + "]";
	}

}
