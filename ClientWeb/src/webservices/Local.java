
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for local complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="local">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessibility" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="address" type="{http://webservices/}address" minOccurs="0"/>
 *         &lt;element name="idLocal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeLocal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "local", propOrder = {
    "accessibility",
    "address",
    "idLocal",
    "name",
    "observations",
    "typeLocal",
    "validated"
})
public class Local {

    @XmlElement(nillable = true)
    protected List<Integer> accessibility;
    protected Address address;
    protected int idLocal;
    protected String name;
    protected String observations;
    protected int typeLocal;
    protected boolean validated;

    /**
     * Gets the value of the accessibility property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessibility property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessibility().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAccessibility() {
        if (accessibility == null) {
            accessibility = new ArrayList<Integer>();
        }
        return this.accessibility;
    }
    
    public void setAccessibility(List<Integer> accessibility) {
		this.accessibility = new ArrayList<Integer>(accessibility);
	}

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the idLocal property.
     * 
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * Sets the value of the idLocal property.
     * 
     */
    public void setIdLocal(int value) {
        this.idLocal = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the observations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservations() {
        return observations;
    }

    /**
     * Sets the value of the observations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservations(String value) {
        this.observations = value;
    }

    /**
     * Gets the value of the typeLocal property.
     * 
     */
    public int getTypeLocal() {
        return typeLocal;
    }

    /**
     * Sets the value of the typeLocal property.
     * 
     */
    public void setTypeLocal(int value) {
        this.typeLocal = value;
    }

    /**
     * Gets the value of the validated property.
     * 
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * Sets the value of the validated property.
     * 
     */
    public void setValidated(boolean value) {
        this.validated = value;
    }

}
