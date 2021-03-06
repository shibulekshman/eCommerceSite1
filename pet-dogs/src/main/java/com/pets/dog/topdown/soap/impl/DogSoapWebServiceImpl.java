package com.pets.dog.topdown.soap.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pets.dog.service.DogService;
import com.pets.dog.soap.web.service.DogFault;
import com.pets.dog.soap.web.service.DogSoapWebService;
import com.pets.dog.soap.web.service.PDog;
import com.pets.dog.soap.web.service.SoapDogFault;
import com.pets.dog.soap.web.service.StringResponse;

@WebService(name = "DogSoapWebService", portName = "DogSoapWebServicePort", serviceName = "DogSoapWebEndpoint", 
		endpointInterface = "com.pets.dog.soap.web.service.DogSoapWebService", targetNamespace = "http://service.web.soap.dog.pets.com/",
		wsdlLocation = "/WEB-INF/wsdl/pet-dogs.wsdl")
@Component("DogSoapWebServiceImpl")
public class DogSoapWebServiceImpl implements DogSoapWebService {

	@Autowired
	private DogService dogService;

	@Override
	public StringResponse addDog(PDog pdog)  throws SoapDogFault{
		
		if(pdog.getArg0().getDid()!=0){
			DogFault dogFault=new DogFault();
			dogFault.setFaultInfo("Id should be zero");
			dogFault.setMessage("Since it is generated by hibernate");
			SoapDogFault dogFaultE=new SoapDogFault("Error because of validation",dogFault);
			throw dogFaultE;
		}
		

		System.out.println("___AA_SS__");
		StringResponse response=new StringResponse();
		response.setReturn("Thanks for calling @ me");
		return response;
	}

	@Override
	@WebMethod(action = "http://service.web.soap.dog.pets.com/deleteDog")
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "deleteDog", targetNamespace = "http://service.web.soap.dog.pets.com/", className = "com.pets.dog.soap.web.service.DeleteDog")
	@ResponseWrapper(localName = "stringResponse", targetNamespace = "http://service.web.soap.dog.pets.com/", className = "com.pets.dog.soap.web.service.StringResponse")
	public String deleteDog(
			@WebParam(name = "delete", targetNamespace = "") String delete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "http://service.web.soap.dog.pets.com/updateDog")
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "updateDog", targetNamespace = "http://service.web.soap.dog.pets.com/", className = "com.pets.dog.soap.web.service.UpdateDog")
	@ResponseWrapper(localName = "stringResponse", targetNamespace = "http://service.web.soap.dog.pets.com/", className = "com.pets.dog.soap.web.service.StringResponse")
	public String updateDog(
			@WebParam(name = "update", targetNamespace = "") String update) {
		// TODO Auto-generated method stub
		return null;
	}

}
