package com.pets.dog.dao.jdbc;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pets.dog.dao.base.AbstractDaoImpl;
import com.pets.dog.dao.hibernate.entity.FileUploadEntity;

@Repository("FileUploadDaoImpl")
@Transactional(propagation = Propagation.REQUIRED)
public class FileUploadDaoImpl extends AbstractDaoImpl<FileUploadEntity, String> implements FileUploadDao{

	
	protected FileUploadDaoImpl() {
        super(FileUploadEntity.class);
    }

	@Override
	public void saveFile(FileUploadEntity fileUploadEntity) {
		saveOrUpdate(fileUploadEntity);
	}

}
