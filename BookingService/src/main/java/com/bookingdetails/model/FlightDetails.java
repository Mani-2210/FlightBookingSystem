package com.bookingdetails.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class FlightDetails {

	private String id;
	private String flightName;
	private String startsFrom;
	private String destination;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateOfFlight;

	public Date getDateOfFlight() {
		return dateOfFlight;
	}

	public void setDateOfFlight(Date dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getStartsFrom() {
		return startsFrom;
	}

	public void setStartsFrom(String startsFrom) {
		this.startsFrom = startsFrom;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getId() {
		return id;
	}

	public void setId(String flightId) {
		this.id = flightId;
	}
public FlightDetails() {}
	public FlightDetails(String id, String flightName, String startsFrom, String destination, Date dateOfFlight) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.startsFrom = startsFrom;
		this.destination = destination;
		this.dateOfFlight = dateOfFlight;
	}
	

}
