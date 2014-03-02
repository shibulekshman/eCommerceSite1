package com.pets.dog.web.model;

import java.util.Date;

public class UserForm {

   private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Date createdOn;
    private Date lastLoginOn;

    public UserForm() {
    }

    public UserForm(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastLoginOn() {
        return lastLoginOn;
    }

    public void setLastLoginOn(Date lastLoginOn) {
        this.lastLoginOn = lastLoginOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserForm user = (UserForm) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return 13 * email.hashCode();
    }

	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password
				+ ", createdOn=" + createdOn + ", lastLoginOn=" + lastLoginOn
				+ "]";
	}
    
    
}
