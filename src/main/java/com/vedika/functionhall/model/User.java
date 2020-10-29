package com.vedika.functionhall.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Registration")
public class User {

	@NotNull(message = "userId is mandatory")
	@NotEmpty(message = "userId is mandatory")
	
   
	private String userId;

	private Boolean isOwner;
	@NotNull(message = "First Name is mandatory")
	@NotEmpty(message = " firstname is mandatory")
	private String firstName;

	@NotNull(message = "lastName is mandatory")
	@NotEmpty(message = " lastName is mandatory")
	private String lastName;
	@NotNull(message = "mobileNumber is mandotory field")
	@NotEmpty(message = "mobileNumber is mandatory")
	private String mobileNumber;
	@NotNull(message = "email is mandatory")
	@NotEmpty(message = " email is mandatory")
	private String email;

	@NotNull(message = "address is mandatory")
	@NotEmpty(message = " address is mandatory")
	private String address;
	@NotNull(message = "address1 is mandatory")
	@NotEmpty(message = " address1 is mandatory")
	private String address1;
	@NotNull(message = "city is mandatory")
	@NotEmpty(message = " city is mandatory")
	private String city;
	@NotNull(message = "zipCode is mandatory")
	@NotEmpty(message = " zipCode is mandatory")
	private String zipCode;

	public Boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", isOwner=" + isOwner + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", address1="
				+ address1 + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

}
