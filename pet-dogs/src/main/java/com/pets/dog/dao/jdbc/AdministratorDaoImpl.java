package com.pets.dog.dao.jdbc;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pets.dog.dao.hibernate.entity.AdministratorEntity;
import com.pets.dog.dao.hibernate.entity.DogEntity;


@Repository("AdministratorDaoImpl")
@Transactional(propagation = Propagation.REQUIRED)
public class AdministratorDaoImpl implements AdministratorDao {
	
	@Autowired
    private SessionFactory psessionFactory;

    public Session getCurrentSession() {
        return psessionFactory.getCurrentSession();
    }

	@Override
	public String getAdministratorPassword(String userName) {
		
		String hql = "FROM AdministratorEntity admin WHERE admin.userName = :name";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("name",userName);
		List<AdministratorEntity> results = query.list();
		if(!results.isEmpty()){
			return results.get(0).getPassword();
		}
		return "";
	}

}
