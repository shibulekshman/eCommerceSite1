
package com.pets.dog.soap.web.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dogFormWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dogFormWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dogForms" type="{http://service.web.soap.dog.pets.com/}dogForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="indexChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalPages" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dogFormWrapper", propOrder = {
    "dogForms",
    "indexChanged",
    "totalCount",
    "totalPages"
})
public class DogFormWrapper {

    @XmlElement(nillable = true)
    protected List<DogForm> dogForms;
    protected boolean indexChanged;
    protected int totalCount;
    protected int totalPages;

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

    /**
     * Gets the value of the indexChanged property.
     * 
     */
    public boolean isIndexChanged() {
        return indexChanged;
    }

    /**
     * Sets the value of the indexChanged property.
     * 
     */
    public void setIndexChanged(boolean value) {
        this.indexChanged = value;
    }

    /**
     * Gets the value of the totalCount property.
     * 
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the value of the totalCount property.
     * 
     */
    public void setTotalCount(int value) {
        this.totalCount = value;
    }

    /**
     * Gets the value of the totalPages property.
     * 
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the value of the totalPages property.
     * 
     */
    public void setTotalPages(int value) {
        this.totalPages = value;
    }

}
