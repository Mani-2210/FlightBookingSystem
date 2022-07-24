package com.bookingdetails.model;

import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookingDetails {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private String flightId;
	

	public String getFlightName() {
		return flightId;
	}

	public void setFlightName(String flightName) {
		this.flightId = flightName;
	}

	public BookingDetails() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
