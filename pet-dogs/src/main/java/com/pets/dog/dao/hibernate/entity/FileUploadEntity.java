package com.pets.dog.dao.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="file_upload_tbl")
public class FileUploadEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fileId;
	@Column(columnDefinition = "longblob")
	private byte[] image1;
	@Column(columnDefinition = "longblob")
	private byte[] image2;
	private String name;
	private String acNumber;
	
	public byte[] getImage1() {
		return image1;
	}
	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}
	public byte[] getImage2() {
		return image2;
	}
	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcNumber() {
		return acNumber;
	}
	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

}
