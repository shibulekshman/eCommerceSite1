package com.pets.dog.dao.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user_tbl")
public class UserEntity {

    @Id
    @Column (name = "email", nullable = false)
    private String email;

	@Column (name = "first_name", nullable = false)
    private String firstName;

    @Column (name = "last_name", nullable = false)
    private String lastName;

    @Column (name = "password", nullable = false)
    private String password;

    @Column (name = "created_on", nullable = false)
    private Date createdOn;

    @Transient
    private Date lastLoginOn;

    public UserEntity() {
    }

    public UserEntity(String email, String firstName, String lastName, String password) {
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

        UserEntity user = (UserEntity) o;

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
