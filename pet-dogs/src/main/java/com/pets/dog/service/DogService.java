package com.pets.dog.service;


/////Test changes



import java.util.List;

import com.pets.dog.web.model.ContactUsForm;
import com.pets.dog.web.model.DogForm;
import com.pets.dog.web.model.UploadFile;
import com.pets.dog.web.model.UserForm;
import com.pets.dog.web.model.wrapper.DogFormWrapper;

/**
 * 
 *  @author astha
 *  
 *   contract to expose following operation through service layer
 */
public interface DogService {
	public String addDog(DogForm dogForm);
	public DogForm findDogById(int did);
	public List<DogForm> findDogs();
	public byte[] findDogImageByDid(int did); 
	public List<DogForm> findLatestDogNews();
	public String deleteDogByDid(int did);
	public String addContactUsDetails(ContactUsForm contactUsForm );
	public DogFormWrapper findCarouselDogs(String cni,String actionType) ;
	public DogFormWrapper findDogsByPageNumber(int pageNumber) ;
	public DogForm updateDog(DogForm dogEntity) ;
	public String saveUser(UserForm userForm);
	public String getAdministratorPassword(String userName);//DO we need a separate service layer for all the different entities?
	public UserForm getUser(String email);
	public boolean addFile(UploadFile uploadFile);
}
