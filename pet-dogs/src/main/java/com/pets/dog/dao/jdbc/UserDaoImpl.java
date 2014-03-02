package com.pets.dog.dao.jdbc;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pets.dog.dao.base.AbstractDaoImpl;
import com.pets.dog.dao.hibernate.entity.AdministratorEntity;
import com.pets.dog.dao.hibernate.entity.DogEntity;
import com.pets.dog.dao.hibernate.entity.UserEntity;
import com.pets.dog.util.DateUtils;

@Repository("UserDaoImpl")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, value = "transactionManager")
public class UserDaoImpl extends AbstractDaoImpl<UserEntity, String> implements
		UserDao {

	@Autowired
	private SessionFactory psessionFactory;

	public Session getCurrentSession() {
		return psessionFactory.getCurrentSession();
	}

	protected UserDaoImpl() {
		super(UserEntity.class);
	}

	@Override
	public void saveUser(UserEntity userEntity) {
		userEntity.setCreatedOn(DateUtils.getCurrentDateInSQLFormat());
		saveOrUpdate(userEntity);
	}

	@Override
	public List<UserEntity> findUsers(String userName) {
		return findByCriteria(Restrictions.like("userName", userName,
				MatchMode.START));
	}

	@Override
	public UserEntity getUserEntity(String email) {
		String hql = "FROM UserEntity u WHERE u.email = :email";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		List<UserEntity> results = query.list();
		if (!results.isEmpty()) {
			return results.get(0);
		}
		return null;
	}
}
