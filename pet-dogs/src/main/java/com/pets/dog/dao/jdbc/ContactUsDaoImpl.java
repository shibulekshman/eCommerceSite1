package com.pets.dog.dao.jdbc;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pets.dog.dao.base.AbstractDaoImpl;
import com.pets.dog.dao.hibernate.entity.ContactUsEntity;

@Repository("ContactUsDaoImpl")
@Transactional(propagation = Propagation.REQUIRED)
public class ContactUsDaoImpl extends AbstractDaoImpl<ContactUsEntity, String> implements ContactUsDao{
	
	protected ContactUsDaoImpl() {
	        super(ContactUsEntity.class);
	    }

	@Override
	public void saveContact(ContactUsEntity contactUsEntity) {
		saveOrUpdate(contactUsEntity);
	}

}
