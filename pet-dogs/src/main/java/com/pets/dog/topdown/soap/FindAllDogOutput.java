
package com.pets.dog.topdown.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findAllDogOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findAllDogOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dogForms" type="{http://service.web.soap.dog.pets.com/}dogForm" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllDogOutput", propOrder = {
    "dogForms"
})
public class FindAllDogOutput {

    @XmlElement(nillable = true)
    protected List<DogForm> dogForms;

    /**
     * Gets the value of the dogForms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dogForms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDogForms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DogForm }
     * 
     * 
     */
    public List<DogForm> getDogForms() {
        if (dogForms == null) {
            dogForms = new ArrayList<DogForm>();
        }
        return this.dogForms;
    }

}
