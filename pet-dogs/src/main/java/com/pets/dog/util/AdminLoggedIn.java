package com.pets.dog.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class AdminLoggedIn {
	
	private String adminName = null;

	public void logoutAdmin() {
		this.adminName = null;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getAdminName() {
		return this.adminName;
	}
	
}