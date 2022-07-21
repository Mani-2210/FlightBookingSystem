package com.bookingdetails.model;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Table
public class BookingDetails {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private Date dateOfTravel;

	public BookingDetails() {
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

	public Date getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(Date dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public BookingDetails(int id, String firstName, String lastName, Date dateOfTravel) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfTravel = dateOfTravel;
	}

}
