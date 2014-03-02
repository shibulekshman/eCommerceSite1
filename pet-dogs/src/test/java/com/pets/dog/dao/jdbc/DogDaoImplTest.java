package com.pets.dog.dao.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pets.dog.dao.hibernate.entity.DogEntity;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true, locations = {"classpath*:test-dog-context.xml"})
@Transactional(propagation = Propagation.REQUIRED,readOnly=false,value="transactionManager")
public class DogDaoImplTest {
	
	@Autowired
	@Qualifier("DogDaoImpl")
	private DogDao dogDaoImpl;
	

	@Test
	public void testAddDog() {
		DogEntity dogEntity = new DogEntity();
		dogEntity.setName("Hi from test2");
		dogEntity.setAddress("Hi from test2");
		assertEquals("success", dogDaoImpl.addDog(dogEntity));
	}

	@Test
	public void testFindDogById() {
		//fail("Not yet implemented");
	}

}
