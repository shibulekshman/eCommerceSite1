package com.pets.dog.dao.jdbc;

import com.pets.dog.dao.base.AbstractDao;
import com.pets.dog.dao.hibernate.entity.FileUploadEntity;

public interface FileUploadDao extends AbstractDao<FileUploadEntity, String>{
	
	public  void saveFile(FileUploadEntity fileUploadEntity);

}
