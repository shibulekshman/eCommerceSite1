package com.pets.dog.util;

import java.util.Comparator;

import com.pets.dog.web.model.DogForm;

public class DogFormComparatorDescendingEmail implements Comparator<DogForm>{
	@Override
	public int compare(DogForm o1, DogForm o2) {
		return o2.getEmail().compareTo(o1.getEmail());
	}

}
