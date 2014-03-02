package com.pets.dog.dao.jdbc;

import com.pets.dog.dao.base.AbstractDao;
import com.pets.dog.dao.hibernate.entity.ContactUsEntity;

public interface ContactUsDao extends AbstractDao<ContactUsEntity, String>{
	
	public  void saveContact(ContactUsEntity contactUsEntity);

}
