package com.pets.dog.dao.hibernate.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dogs_tbl")
public class DogEntity {
		
		private String imageId;
	 	private int did;
	    private String name;
	    private String title;
	    private String email;
	    private String color;
	    private String owner;
	    private String address;
	    private Date dob;
	    private byte[] image;
	    private String breed;
	    private String sex;
	    private String description;
	    protected String price;
	    private Date dou;
	    
	    public Date getDou() {
			return dou;
		}
		public void setDou(Date dou) {
			this.dou = dou;
		}
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public int getDid() {
			return did;
		}
		public void setDid(int did) {
			this.did = did;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		
		@Column(columnDefinition = "LONGBLOB")
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}
		public String getBreed() {
			return breed;
		}
		public void setBreed(String breed) {
			this.breed = breed;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "DogEntity [did=" + did + ", name=" + name + ", title="
					+ title + ", email=" + email + ", color=" + color
					+ ", owner=" + owner + ", address=" + address + ", dob="
					+ dob + ", image=" +", breed="
					+ breed + ", sex=" + sex + ", description=" + description
					+ ", price=" + price + "]";
		}
		public void setImageId(String imageId) {
			this.imageId = imageId;
		}
		public String getImageId() {
			return imageId;
		}

}
