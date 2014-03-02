package com.pets.dog.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pets.dog.service.DogServiceImpl;
import com.pets.dog.web.model.DogForm;
import com.pets.dog.web.model.wrapper.DogFormWrapper;


@Controller
public class DogRestWebServiceProvider {  //How is this class getting mapped? How is this controller auto-wired? 
	//Is this being mapped because there can be more than one controller in a program? Yes this controller is being used for rest service 
	//providing. This is the REST implementation using Spring3.0. 
	
	@Autowired
	@Qualifier("DogServiceImpl")
	private DogServiceImpl dogService;
	
	/*	<servlet-mapping>
	<servlet-name>pet-dogs</servlet-name>
	<url-pattern>/apps/*</url-pattern>
</servlet-mapping>
*/

	//path prefix
	//http://localhost:3043/pet-dogs/app/dog/18
	@RequestMapping(value="/dog/{dogid}",method=RequestMethod.GET,headers = "Accept=application/xml",produces="application/xml")
	public  @ResponseBody DogForm findDogById(@PathVariable("dogid") int did){
		DogForm dogForm=dogService.findDogById(did);
		return dogForm;
	}
	
	@RequestMapping(value="/dog/{dogid}",method=RequestMethod.GET,headers = "Accept=application/json",produces="application/json")
	public  @ResponseBody DogForm findDogByIdJSON(@PathVariable("dogid") int did){
		DogForm dogForm=dogService.findDogById(did);
		return dogForm;
	}
	
	
	@RequestMapping(value="/all/dogs",method=RequestMethod.GET,headers = "Accept=application/xml",produces="application/xml")
	public @ResponseBody DogFormWrapper showDogs(){
		List<DogForm> dogForms=dogService.findDogs();
		DogFormWrapper dogFormWrapper=new DogFormWrapper();
		dogFormWrapper.setDogForms(dogForms);
		return dogFormWrapper;
	}
	
	@RequestMapping(value="/all/dogs",method=RequestMethod.GET,headers = "Accept=application/json",produces="application/json")
	public @ResponseBody DogFormWrapper showDogsInJSON(){
		List<DogForm> dogForms=dogService.findDogs();
		DogFormWrapper dogFormWrapper=new DogFormWrapper();
		dogFormWrapper.setDogForms(dogForms);
		return dogFormWrapper;
	}
	
	

}
