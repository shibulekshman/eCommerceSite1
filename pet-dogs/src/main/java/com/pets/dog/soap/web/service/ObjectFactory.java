
package com.pets.dog.soap.web.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pets.dog.soap.web.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindDogsResponse_QNAME = new QName("http://service.web.soap.dog.pets.com/", "findDogsResponse");
    private final static QName _StringResponse_QNAME = new QName("http://service.web.soap.dog.pets.com/", "stringResponse");
    private final static QName _FindDogsInput_QNAME = new QName("http://service.web.soap.dog.pets.com/", "findDogsInput");
    private final static QName _UpdateDog_QNAME = new QName("http://service.web.soap.dog.pets.com/", "updateDog");
    private final static QName _DogForm_QNAME = new QName("http://service.web.soap.dog.pets.com/", "dogForm");
    private final static QName _DogFault_QNAME = new QName("http://service.web.soap.dog.pets.com/", "dogFault");
    private final static QName _UploadDog_QNAME = new QName("http://service.web.soap.dog.pets.com/", "uploadDog");
    private final static QName _DeleteDog_QNAME = new QName("http://service.web.soap.dog.pets.com/", "deleteDog");
    private final static QName _DogFormWrapper_QNAME = new QName("http://service.web.soap.dog.pets.com/", "dogFormWrapper");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pets.dog.soap.web.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateDog }
     * 
     */
    public UpdateDog createUpdateDog() {
        return new UpdateDog();
    }

    /**
     * Create an instance of {@link DogFault }
     * 
     */
    public DogFault createDogFault() {
        return new DogFault();
    }

    /**
     * Create an instance of {@link DogForm }
     * 
     */
    public DogForm createDogForm() {
        return new DogForm();
    }

    /**
     * Create an instance of {@link StringResponse }
     * 
     */
    public StringResponse createStringResponse() {
        return new StringResponse();
    }

    /**
     * Create an instance of {@link FindDogsResponse }
     * 
     */
    public FindDogsResponse createFindDogsResponse() {
        return new FindDogsResponse();
    }

    /**
     * Create an instance of {@link FindDogsInput }
     * 
     */
    public FindDogsInput createFindDogsInput() {
        return new FindDogsInput();
    }

    /**
     * Create an instance of {@link DogFormWrapper }
     * 
     */
    public DogFormWrapper createDogFormWrapper() {
        return new DogFormWrapper();
    }

    /**
     * Create an instance of {@link PDog }
     * 
     */
    public PDog createPDog() {
        return new PDog();
    }

    /**
     * Create an instance of {@link DeleteDog }
     * 
     */
    public DeleteDog createDeleteDog() {
        return new DeleteDog();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDogsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "findDogsResponse")
    public JAXBElement<FindDogsResponse> createFindDogsResponse(FindDogsResponse value) {
        return new JAXBElement<FindDogsResponse>(_FindDogsResponse_QNAME, FindDogsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "stringResponse")
    public JAXBElement<StringResponse> createStringResponse(StringResponse value) {
        return new JAXBElement<StringResponse>(_StringResponse_QNAME, StringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDogsInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "findDogsInput")
    public JAXBElement<FindDogsInput> createFindDogsInput(FindDogsInput value) {
        return new JAXBElement<FindDogsInput>(_FindDogsInput_QNAME, FindDogsInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "updateDog")
    public JAXBElement<UpdateDog> createUpdateDog(UpdateDog value) {
        return new JAXBElement<UpdateDog>(_UpdateDog_QNAME, UpdateDog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DogForm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "dogForm")
    public JAXBElement<DogForm> createDogForm(DogForm value) {
        return new JAXBElement<DogForm>(_DogForm_QNAME, DogForm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DogFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "dogFault")
    public JAXBElement<DogFault> createDogFault(DogFault value) {
        return new JAXBElement<DogFault>(_DogFault_QNAME, DogFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PDog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "uploadDog")
    public JAXBElement<PDog> createUploadDog(PDog value) {
        return new JAXBElement<PDog>(_UploadDog_QNAME, PDog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "deleteDog")
    public JAXBElement<DeleteDog> createDeleteDog(DeleteDog value) {
        return new JAXBElement<DeleteDog>(_DeleteDog_QNAME, DeleteDog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DogFormWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.soap.dog.pets.com/", name = "dogFormWrapper")
    public JAXBElement<DogFormWrapper> createDogFormWrapper(DogFormWrapper value) {
        return new JAXBElement<DogFormWrapper>(_DogFormWrapper_QNAME, DogFormWrapper.class, null, value);
    }

}
