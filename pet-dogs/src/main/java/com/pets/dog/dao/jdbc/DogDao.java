package com.pets.dog.dao.jdbc;

import java.util.List;

import com.pets.dog.dao.hibernate.entity.DogEntity;
import com.pets.dog.dao.hibernate.entity.wrapper.DogEntityWrapper;

public interface DogDao {
	public String addDog(DogEntity dogEntity);
	public DogEntity findDogById(int did);
	public List<DogEntity> findDogs();
	public byte[] findDogImageByDid(int did);
	public List<DogEntity> findLatestDogNews();
	public String deleteDogByDid(int did);
	public DogEntityWrapper findCarouselDogs(String cindex, String actionType);
	public DogEntityWrapper findDogsByPageNumber(int pageNumber);
	public DogEntity updateDog(DogEntity dogEntity);
	}
