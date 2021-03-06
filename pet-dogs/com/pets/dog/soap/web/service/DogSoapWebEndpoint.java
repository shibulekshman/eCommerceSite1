
package com.pets.dog.soap.web.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DogSoapWebEndpoint", targetNamespace = "http://service.web.soap.dog.pets.com/", wsdlLocation = "file:/D:/Synergistic%20DATA/workspace_apr_2013/Spring-WS1_OCT2013/pet-dogs/src/main/webapp/WEB-INF/wsdl/pet-dogs.wsdl")
public class DogSoapWebEndpoint
    extends Service
{

    private final static URL DOGSOAPWEBENDPOINT_WSDL_LOCATION;
    private final static WebServiceException DOGSOAPWEBENDPOINT_EXCEPTION;
    private final static QName DOGSOAPWEBENDPOINT_QNAME = new QName("http://service.web.soap.dog.pets.com/", "DogSoapWebEndpoint");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/Synergistic%20DATA/workspace_apr_2013/Spring-WS1_OCT2013/pet-dogs/src/main/webapp/WEB-INF/wsdl/pet-dogs.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DOGSOAPWEBENDPOINT_WSDL_LOCATION = url;
        DOGSOAPWEBENDPOINT_EXCEPTION = e;
    }

    public DogSoapWebEndpoint() {
        super(__getWsdlLocation(), DOGSOAPWEBENDPOINT_QNAME);
    }

    public DogSoapWebEndpoint(WebServiceFeature... features) {
        super(__getWsdlLocation(), DOGSOAPWEBENDPOINT_QNAME, features);
    }

    public DogSoapWebEndpoint(URL wsdlLocation) {
        super(wsdlLocation, DOGSOAPWEBENDPOINT_QNAME);
    }

    public DogSoapWebEndpoint(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DOGSOAPWEBENDPOINT_QNAME, features);
    }

    public DogSoapWebEndpoint(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DogSoapWebEndpoint(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DogSoapWebService
     */
    @WebEndpoint(name = "DogSoapWebServicePort")
    public DogSoapWebService getDogSoapWebServicePort() {
        return super.getPort(new QName("http://service.web.soap.dog.pets.com/", "DogSoapWebServicePort"), DogSoapWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DogSoapWebService
     */
    @WebEndpoint(name = "DogSoapWebServicePort")
    public DogSoapWebService getDogSoapWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.web.soap.dog.pets.com/", "DogSoapWebServicePort"), DogSoapWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DOGSOAPWEBENDPOINT_EXCEPTION!= null) {
            throw DOGSOAPWEBENDPOINT_EXCEPTION;
        }
        return DOGSOAPWEBENDPOINT_WSDL_LOCATION;
    }

}
