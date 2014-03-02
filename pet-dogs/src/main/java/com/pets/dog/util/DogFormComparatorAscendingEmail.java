package com.pets.dog.util;

import java.util.Comparator;

import com.pets.dog.web.model.DogForm;

public class DogFormComparatorAscendingEmail implements Comparator<DogForm>{

	@Override
	public int compare(DogForm o1, DogForm o2) {
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
