package com.pets.dog.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pets.dog.dao.hibernate.entity.ContactUsEntity;
import com.pets.dog.dao.hibernate.entity.DogEntity;
import com.pets.dog.dao.hibernate.entity.FileUploadEntity;
import com.pets.dog.dao.hibernate.entity.UserEntity;
import com.pets.dog.dao.hibernate.entity.wrapper.DogEntityWrapper;
import com.pets.dog.dao.jdbc.AdministratorDao;
import com.pets.dog.dao.jdbc.ContactUsDao;
import com.pets.dog.dao.jdbc.DogDao;
import com.pets.dog.dao.jdbc.FileUploadDao;
import com.pets.dog.dao.jdbc.UserDao;
import com.pets.dog.web.model.ContactUsForm;
import com.pets.dog.web.model.DogForm;
import com.pets.dog.web.model.UploadFile;
import com.pets.dog.web.model.UserForm;
import com.pets.dog.web.model.wrapper.DogFormWrapper;

@Service("DogServiceImpl")
public class DogServiceImpl implements DogService {

	@Autowired
	@Qualifier("AdministratorDaoImpl")
	private AdministratorDao administratorDao;

	@Autowired
	@Qualifier("DogDaoImpl")
	private DogDao dogDao;

	@Autowired
	@Qualifier("ContactUsDaoImpl")
	private ContactUsDao contactUsDao;// //I bought this in, we probably need a
										// seperate service layer for each
										// entity

	@Autowired
	@Qualifier("UserDaoImpl")
	private UserDao userDao;

	@Autowired
	@Qualifier("FileUploadDaoImpl")
	private FileUploadDao fileUploadDao;

	@Override
	public String addDog(DogForm dogForm) {
		System.out
				.println("Is spring tx working in service = "
						+ TransactionSynchronizationManager
								.isActualTransactionActive());
		// We have to convert DogForm into DogEntity
		DogEntity dogEntity = BeanUtils.instantiate(DogEntity.class);
		BeanUtils.copyProperties(dogForm, dogEntity);
		return dogDao.addDog(dogEntity);
	}

	@Override
	public DogForm findDogById(int did) {
		DogEntity dogEntity = dogDao.findDogById(did);
		DogForm dogForm = null;
		if (dogEntity != null) {
			dogForm = BeanUtils.instantiate(DogForm.class);
			BeanUtils.copyProperties(dogEntity, dogForm);
		}
		return dogForm;
	}

	@Override
	public List<DogForm> findDogs() {
		List<DogEntity> dogEntities = dogDao.findDogs();
		List<DogForm> dogForms = new ArrayList<DogForm>();
		for (DogEntity de : dogEntities) {
			DogForm dogForm = BeanUtils.instantiate(DogForm.class);
			BeanUtils.copyProperties(de, dogForm);
			dogForms.add(dogForm);
		}
		return dogForms;
	}

	@Override
	public byte[] findDogImageByDid(int did) {
		return dogDao.findDogImageByDid(did);
	}

	@Override
	public List<DogForm> findLatestDogNews() {
		long startTime = System.currentTimeMillis();
		List<DogEntity> dogEntities = dogDao.findLatestDogNews();
		List<DogForm> dogForms = new ArrayList<DogForm>();
		for (DogEntity de : dogEntities) {
			DogForm dogForm = BeanUtils.instantiate(DogForm.class);
			BeanUtils.copyProperties(de, dogForm);
			dogForms.add(dogForm);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("time taken by this method = "
				+ (endTime - startTime));
		return dogForms;
	}

	@Override
	public DogFormWrapper findCarouselDogs(String cni, String actionType) {
		DogEntityWrapper dogEntityWrapper = dogDao.findCarouselDogs(cni,
				actionType);
		List<DogForm> dogForms = new ArrayList<DogForm>();
		for (DogEntity de : dogEntityWrapper.getDogEntities()) {
			DogForm dogForm = BeanUtils.instantiate(DogForm.class);
			BeanUtils.copyProperties(de, dogForm);
			dogForms.add(dogForm);
		}
		DogFormWrapper dogFormWrapper = new DogFormWrapper();
		dogFormWrapper.setDogForms(dogForms);
		dogFormWrapper.setIndexChanged(dogEntityWrapper.isIndexChanged());
		return dogFormWrapper;
	}

	@Override
	public String deleteDogByDid(int did) {
		return dogDao.deleteDogByDid(did);
	}

	@Override
	public String addContactUsDetails(ContactUsForm contactUsForm) {
		ContactUsEntity contactUsEntity = BeanUtils
				.instantiate(ContactUsEntity.class);
		BeanUtils.copyProperties(contactUsForm, contactUsEntity);
		contactUsDao.saveContact(contactUsEntity);
		return "Success";
	}

	@Override
	public DogFormWrapper findDogsByPageNumber(int pageNumber) {
		DogEntityWrapper dogEntityWrapper = dogDao
				.findDogsByPageNumber(pageNumber);
		List<DogForm> dogForms = new ArrayList<DogForm>();
		for (DogEntity de : dogEntityWrapper.getDogEntities()) {
			DogForm dogForm = BeanUtils.instantiate(DogForm.class);
			BeanUtils.copyProperties(de, dogForm);
			dogForms.add(dogForm);
		}
		DogFormWrapper dogFormWrapper = new DogFormWrapper();
		dogFormWrapper.setDogForms(dogForms);
		dogFormWrapper.setTotalCount(dogEntityWrapper.getTotalCount());
		return dogFormWrapper;
	}

	@Override
	public DogForm updateDog(DogForm dogForm) {
		DogEntity dogEntity = BeanUtils.instantiate(DogEntity.class);
		BeanUtils.copyProperties(dogForm, dogEntity);
		DogEntity dogEntity2 = (DogEntity) dogDao.updateDog(dogEntity);
		DogForm dDogForm = BeanUtils.instantiate(DogForm.class);
		BeanUtils.copyProperties(dogEntity2, dDogForm);
		return dDogForm;
	}

	@Override
	public String saveUser(UserForm userForm) {
		UserEntity userEntity = BeanUtils.instantiate(UserEntity.class);
		BeanUtils.copyProperties(userForm, userEntity);
		userDao.saveUser(userEntity);
		return "Success";
	}

	@Override
	public String getAdministratorPassword(String userName) {
		return administratorDao.getAdministratorPassword(userName);
	}

	@Override
	public UserForm getUser(String email) {
		UserForm userForm = BeanUtils.instantiate(UserForm.class);
		BeanUtils.copyProperties(userDao.getUserEntity(email), userForm);
		return userForm;
	}

	@Override
	public boolean addFile(UploadFile uploadFile) {
		
		FileUploadEntity fileUploadEntity = new FileUploadEntity();
		String fileName = "temp.zip"; // Is this approach thread safe?

		try {

			FileOutputStream outputStream = new FileOutputStream(fileName);
			outputStream.write(uploadFile.getFile());

			outputStream.close();

			System.out.println("Wrote " + uploadFile.getFile().length
					+ " bytes");
		} catch (IOException ex) {
			System.out.println("Error writing file '" + fileName + "'");
		}

		// trying to extract
		
		final int BUFFER = 150000;

		try {
			
			BufferedOutputStream dest = null;
			BufferedInputStream is = null;
			ZipEntry entry1;
			ZipEntry entry2;
			ZipEntry entry3;
			ZipFile zipfile = new ZipFile("temp.zip");
			
			entry1 = (ZipEntry) zipfile.getEntry("images/apple.jpg");
			entry2 = (ZipEntry) zipfile.getEntry("images/mango.jpg");
			entry3 = (ZipEntry) zipfile.getEntry("images/info.csv");
			
			
			System.out.println("Extracting: " + entry1);
			
			byte data1[] = new byte[BUFFER];
			is = new BufferedInputStream(zipfile.getInputStream(entry1));
			is.read(data1);
			fileUploadEntity.setImage1(data1);
			
			System.out.println("Extracting: " + entry2);
			
			byte data2[] = new byte[BUFFER];
			is = new BufferedInputStream(zipfile.getInputStream(entry2));
			is.read(data2);
			fileUploadEntity.setImage2(data2);
			
			System.out.println("Extracting: " + entry3);
			
			byte data3[] = new byte[BUFFER];
			is = new BufferedInputStream(zipfile.getInputStream(entry3));
			is.read(data3);
			
			
			String csv = new String(data3);
			String[] split = csv.split(",");
			fileUploadEntity.setName(split[0].trim());
			fileUploadEntity.setAcNumber(split[1].trim());			
			
			System.out.println(split[0]);
			System.out.println(split[1]);
			
			fileUploadDao.saveFile(fileUploadEntity);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
