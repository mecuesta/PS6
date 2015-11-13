package domain;


import java.time.LocalDate;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {
	
	protected UUID personID;
    protected  String firstName;
    protected  String lastName;
    protected  String street;
    protected  Integer postalCode;
    protected  String city;
    protected  LocalDate birthday;

    /**
     * Default constructor.
     */
    public PersonDomainModel() {
    	
    }
    
    public PersonDomainModel(String FirstName, String LastName,
    		String Street, Integer PostalCode, String City,
    		LocalDate Birthday) {
    	super();
    	firstName = FirstName;
    	lastName = LastName;
    	street = Street;
    	postalCode = PostalCode;
    	city = City;
    	birthday = Birthday;
    }
    
    public PersonDomainModel(PersonDomainModel per) {
    	firstName = per.getFirstName();
    	lastName = per.getLastName();
    	street = per.getStreet();
    	postalCode = per.getPostalCode();
    	city = per.getCity();
    	birthday = per.getBirthday();
    }
    
    public PersonDomainModel(UUID PersonID) {
		super();
		personID = PersonID;		
	}
    
    public UUID getPersonID() {
    	return personID;
    }
    
    public void setPersonID(UUID PersonID) {
    	this.personID = PersonID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}