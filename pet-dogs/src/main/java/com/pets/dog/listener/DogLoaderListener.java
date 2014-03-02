package com.pets.dog.listener;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pets.dog.service.DogService;
import com.pets.dog.web.model.DogForm;

/**
 * 
 * @author yadna01
 *
 */
public class DogLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		  ServletContext context=sce.getServletContext();
		  //Here I am going to access spring root web application context
			ApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(context);
			DogService dogService=(DogService)applicationContext.getBean("DogServiceImpl");
			Properties properties=new Properties();
			//loading the properties file
			java.io.InputStream inStream=context.getResourceAsStream("/WEB-INF/context/dogs-dvalues.properties");
			try {
				properties.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String did=properties.getProperty("d1.did");
			int ddd=Integer.parseInt(did);
			if(dogService.findDogById(ddd)==null){
				DogForm dogForm=new DogForm();
				dogForm.setName(properties.getProperty("d1.name"));
				dogForm.setColor(properties.getProperty("d1.color"));
				dogForm.setEmail(properties.getProperty("d1.email"));
				dogForm.setTitle(properties.getProperty("d1.title"));
				dogForm.setOwner(properties.getProperty("d1.owner"));
				dogForm.setAddress(properties.getProperty("d1.address"));
				java.io.InputStream image1=context.getResourceAsStream("/WEB-INF/dogs/dog1.jpg");
				try {
					byte ima[]=IOUtils.toByteArray(image1);
					dogForm.setImage(ima);
					dogService.addDog(dogForm);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DogForm dogForm2=new DogForm();
				dogForm2.setName(properties.getProperty("d2.name"));
				dogForm2.setColor(properties.getProperty("d2.color"));
				dogForm2.setEmail(properties.getProperty("d2.email"));
				dogForm2.setTitle(properties.getProperty("d2.title"));
				dogForm2.setOwner(properties.getProperty("d2.owner"));
				dogForm2.setAddress(properties.getProperty("d2.address"));
				java.io.InputStream image2=context.getResourceAsStream("/WEB-INF/dogs/dog2.jpg");
				try {
					byte ima[]=IOUtils.toByteArray(image2);
					dogForm2.setImage(ima);
					dogService.addDog(dogForm2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

}
