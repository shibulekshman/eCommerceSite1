package com.pets.dog.topdown.soap.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.pets.dog.topdown.soap.DogForm;
import com.pets.dog.topdown.soap.DogSoapWebService;
import com.pets.dog.topdown.soap.FindAllDogOutput;
import com.pets.dog.topdown.soap.FindDogsInput;
import com.pets.dog.topdown.soap.PDog;
import com.pets.dog.topdown.soap.SoapDogFault;
import com.pets.dog.topdown.soap.StringResponse;

@WebService(name = "DogSoapWebService", portName = "DogSoapWebServicePort", serviceName = "DogSoapWebEndpoint",
endpointInterface = "com.pets.dog.topdown.soap.DogSoapWebService", targetNamespace = "http://service.web.soap.dog.pets.com/",
wsdlLocation = "/WEB-INF/wsdl/pet-dogs.wsdl")
@Component("DogSoapWebServiceImpl2")
public class DogSoapWebServiceImpl2 implements DogSoapWebService{

	@Override
	@WebMethod(action = "http://service.web.soap.dog.pets.com/addDog")
	@WebResult(name = "stringResponse", targetNamespace = "http://service.web.soap.dog.pets.com/", partName = "rstring")
	public StringResponse addDog(
			@WebParam(name = "uploadDog", targetNamespace = "http://service.web.soap.dog.pets.com/", partName = "pdog") PDog pdog)
			throws SoapDogFault {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "http://service.web.soap.dog.pets.com/findAllDogs")
	@WebResult(name = "findAllDogsOutputParam", targetNamespace = "http://service.web.soap.dog.pets.com/", partName = "findAllDogsResponseParam")
	public FindAllDogOutput findAllDogs(
			@WebParam(name = "findAllDogsInputParam", targetNamespace = "http://service.web.soap.dog.pets.com/", partName = "findAllDogsRequestParam") FindDogsInput findAllDogsRequestParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "http://service.web.soap.dog.pets.com/findDogById")
	@WebResult(name = "findDogByIdOutputParam", targetNamespace = "http://service.web.soap.dog.pets.com/", partName = "findDogByIdResponseParam")
	public DogForm findDogById(
			@WebParam(name = "findDogByIdInputParam", targetNamespace = "http://service.web.soap.dog.pets.com/", partName = "findDogByIdRequestParam") int findDogByIdRequestParam) {
		// TODO Auto-generated method stub
		DogForm dogForm=new DogForm();
		dogForm.setDid(122);
		dogForm.setColor("brown");
		dogForm.setName("rocky");
		return dogForm;
	}

}
