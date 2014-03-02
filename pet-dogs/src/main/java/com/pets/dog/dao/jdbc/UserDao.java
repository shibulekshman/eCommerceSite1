package com.pets.dog.dao.jdbc;

import java.util.List;

import com.pets.dog.dao.base.AbstractDao;
import com.pets.dog.dao.hibernate.entity.UserEntity;

public interface UserDao extends AbstractDao<UserEntity, String> {
	
	public void saveUser(UserEntity userEntity);

	public List<UserEntity> findUsers(String userName);

	public UserEntity getUserEntity(String email);
	
}
