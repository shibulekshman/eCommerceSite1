package com.pets.dog.web.model;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Why is this here? This is for the restful webservice. This is being marshalled using JaxB to send over net.
public class DogForm {
		
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
			return "DogModel [did=" + did + ", name=" + name + ", title="
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
