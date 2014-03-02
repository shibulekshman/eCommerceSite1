package com.pets.dog.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class ShoppingCart {

	private List<Integer> shoppingCartItems = new ArrayList<Integer>();
	
	//deletes the element from the list and sends back confirmation in the form of boolean
	public boolean deleteEntry(Integer dogId) {
		
		return shoppingCartItems.remove(dogId);
		
		/*for(int i = 0; i < shoppingCartItems.size(); i++) {
			if(shoppingCartItems.get(i) == dogId) {
				
				return true;
			}
		}
		
		return false;*/
	}
	
	//returns the list of all ids
	public List<Integer> getShoppingCartItems() {
		return shoppingCartItems;
	}

	// Checks if the list is empty and returns the boolean result
	public boolean checkEmpty() {

		return shoppingCartItems.isEmpty();

	}
	
	//check if the passed dogId is already in the list, if it is returns true otherwise returns false
	public boolean checkIdPresent(Integer dogId) {
		
		return shoppingCartItems.contains(dogId);
		
		/*for (Integer item : shoppingCartItems) {
			if (item.equals(dogId)) {
				return true;
			}
		}
		
		return false;*/
	}

	// returns the comma delimited string of values(dog IDs) in the shopping
	// cart.
	public String ShoppingCartItemsToString() {

		StringBuilder str = new StringBuilder();

		for (Integer item : shoppingCartItems) {
			str.append(item.toString() + ",");
		}

		return str.toString();

	}
	
	//Add a value(dog ID) into the shopping cart
	public void addshoppingCartItem(Integer item) {
		
		shoppingCartItems.add(item);
		
	}

}
