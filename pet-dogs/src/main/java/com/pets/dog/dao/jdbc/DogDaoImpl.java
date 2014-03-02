package com.pets.dog.dao.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pets.dog.constant.PetDogsApplicationConstant;
import com.pets.dog.dao.base.AbstractDaoImpl;
import com.pets.dog.dao.hibernate.entity.DogEntity;
import com.pets.dog.dao.hibernate.entity.wrapper.DogEntityWrapper;
import com.pets.dog.util.DateUtils;

@Repository("DogDaoImpl")
@Transactional(propagation = Propagation.REQUIRED,readOnly=false,value="transactionManager",isolation=Isolation.DEFAULT)
public class DogDaoImpl extends AbstractDaoImpl<DogEntity, Integer> implements
		DogDao {

	protected DogDaoImpl() {
		super(DogEntity.class);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public String addDog(DogEntity dogEntity) {
		//System.out.println("Good Morning  =addDog ");
		System.out
				.println("Is spring tx working = "
						+ TransactionSynchronizationManager
								.isActualTransactionActive());
		// getHibernateTemplate().save(dogEntity);
		dogEntity.setDou(DateUtils.getCurrentDateInSQLFormat());
		saveOrUpdate(dogEntity);
		return "success";
	}

	@Override
	//@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public DogEntity findDogById(int did) {
		return findById(new Integer(did));
		// return getHibernateTemplate().get(DogEntity.class, did);
	}

	@Override
	public List<DogEntity> findDogs() {
		// List<DogEntity>
		// dogEntities=getHibernateTemplate().find(" from DogEntity");
		return findAll();
		// return dogEntities;
	}

	@Override
	public byte[] findDogImageByDid(int did) {
		return findById(new Integer(did)).getImage();
		// DogEntity
		// dogEntity=(DogEntity)getHibernateTemplate().get(DogEntity.class,
		// did);
		// return dogEntity.getImage();
	}

	@Override
	public List<DogEntity> findLatestDogNews() {
		List<DogEntity> dogEntities = getCurrentSession()
				.createQuery("FROM DogEntity de  ORDER BY de.dou asc")
				.setMaxResults(2).list();
		return dogEntities;
	}

	
	//cni=5
	@Override
	public DogEntityWrapper findCarouselDogs(String cni,String actionType) {
		DogEntityWrapper dogEntityWrapper=new DogEntityWrapper();
		int startIndex=0;
		//2 6
		//1 5
		if("nextImage".equals(actionType)){
			startIndex=Integer.parseInt(cni)-3;
		}else	if("preImage".equals(actionType)){
			//when no previous image exists , previous index would be zero
			if(Integer.parseInt(cni)==0) {
				dogEntityWrapper.setIndexChanged(false);
				return dogEntityWrapper; 
			}
			startIndex=Integer.parseInt(cni)-1;
		}
		int count = ((Long)getCurrentSession().createQuery("select count(*) from DogEntity").uniqueResult()).intValue();
		org.hibernate.Query query = getCurrentSession().createQuery("from DogEntity");
		if(count>startIndex+4) {
			query.setFirstResult(startIndex); //from  DogEntity where rownum=1 and mx
			query.setMaxResults(5);
		}else{
			query.setFirstResult(count-5);
			query.setMaxResults(5);
			dogEntityWrapper.setIndexChanged(false);
		}
	    List<DogEntity> dogEntities=query.list();
	    dogEntityWrapper.setDogEntities(dogEntities);
		return dogEntityWrapper;
	}

	@Override
	public String deleteDogByDid(int did) {
		DogEntity dogEntity = super.findById(did);
		super.delete(dogEntity);
		return "success";
	}

	@Override
	public DogEntityWrapper findDogsByPageNumber(int pageNumber) {
		int startIndex = (pageNumber-1) * 3;
		int maxResult;
		int count = ((Long)getCurrentSession().createQuery("select count(*) from DogEntity").uniqueResult()).intValue();
		if( (count - startIndex) > 3 ) {
			maxResult = 3;
		}else{
			maxResult = count - startIndex;
		}
		org.hibernate.Query query = getCurrentSession().createQuery("from DogEntity");
		query.setFirstResult(startIndex); 
		query.setMaxResults(PetDogsApplicationConstant.PAGE_SIZE);
	    List<DogEntity> dogEntities=query.list();
	    DogEntityWrapper dogEntityWrapper=new DogEntityWrapper();
	    dogEntityWrapper.setDogEntities(dogEntities);
	    dogEntityWrapper.setTotalCount(count);
        return dogEntityWrapper;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("D:\\Synergistic DATA\\workspace_apr_2013\\Spring-WS1_OCT2013\\pet-dogs\\src\\main\\webapp\\WEB-INF\\context\\dog-context.xml");
		System.out.println("___++___++");
	}

	@Override
	public DogEntity updateDog(DogEntity dogEntity) {
		//getCurrentSession().merge(dogEntity);
		//DogEntity entity=(DogEntity)getCurrentSession().merge(dogEntity);
		getCurrentSession().update(dogEntity);
		//return entity;
		return dogEntity;
	}

	
}
