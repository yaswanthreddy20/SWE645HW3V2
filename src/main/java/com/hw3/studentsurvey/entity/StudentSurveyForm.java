package com.hw3.studentsurvey.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "survey_form_data")
public class StudentSurveyForm {
	private static final Logger LOGGER = Logger.getLogger( StudentSurveyForm.class.getName());
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_survey")
    private Date dateOfSurvey;
    @Column(name = "liked_about_campus")
    private String likedAboutCampus;
    @Column(name = "heard_from")
    private String heardFrom;
    @Column(name = "recommend")
    private String recommend;
    
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfSurvey() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String d =  formatter.format(dateOfSurvey);
		System.out.println(d);
        LOGGER.log(Level.INFO, d);
		return d;
	}
	public void setDateOfSurvey(Date dateOfSurvey) {
		this.dateOfSurvey = dateOfSurvey;
	}
	public String getLikedAboutCampus() {
		return likedAboutCampus;
	}
	public void setLikedAboutCampus(String likedAboutCampus) {
		this.likedAboutCampus = likedAboutCampus;
	}
	public String getHeardFrom() {
		return heardFrom;
	}
	public void setHeardFrom(String heardFrom) {
		this.heardFrom = heardFrom;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
    
	
    
}
