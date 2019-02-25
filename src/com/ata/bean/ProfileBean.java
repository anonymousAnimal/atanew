package com.ata.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ata_tbl_user_profile")
public class ProfileBean {
	
	@Id
	private String userID;
	
	@NotEmpty(message="not empty")
	private String firstName;
	@NotEmpty(message="cannot be empty")
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") // This is for bind Date with @ModelAttribute
	@Temporal(value=TemporalType.DATE)
	@Past(message="please enter past date")
	private Date dateOfBirth;
	@NotEmpty(message="cannot be empty")
	private String gender;
	@NotEmpty(message="cannot be empty")
	private String street;
	@NotEmpty(message="cannot be empty")
	private String location;
	@NotEmpty(message="cannot be empty")
	private String city;
	@NotEmpty(message="cannot be empty")
	private String state;
	@NotEmpty(message="cannot be empty")
	private String pincode;
	@NotEmpty(message="cannot be empty")
	private String mobileNo;
	private String emailID;
	@Transient
	@NotEmpty(message="cannot be empty")
	private String password;
	
	public ProfileBean() {
		super();
	}
	public ProfileBean(String userID, String firstName, String lastName,
			Date dateOfBirth, String gender, String street, String location,
			String city, String state, String pincode, String mobileNo,
			String emailID, String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailID = emailID;
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ProfileBean [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfbirth=" + dateOfBirth + ", gender=" + gender + ", street=" + street + ", location="
				+ location + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo=" + mobileNo
				+ ", emailID=" + emailID + ", password=" + password + "]";
	}
	
	

}
