package com.flightdetails.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FlightDetails {
	private String flightName;

	public FlightDetails(String flightName, String startsFrom, String destination, int id) {
		this.flightName = flightName;
		this.startsFrom = startsFrom;
		this.destination = destination;
		this.id = id;
	}
	public FlightDetails() {}

	private String startsFrom;
	private String destination;
	private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
