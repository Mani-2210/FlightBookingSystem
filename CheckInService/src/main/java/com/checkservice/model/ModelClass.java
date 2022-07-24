package com.checkservice.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "details")
public class ModelClass {
	
	private String flightName;
	private Map<String, List> seats;
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Map<String, List> getSeats() {
		return seats;
	}
	public void setSeats(Map<String, List> seats) {
		this.seats = seats;
	}
	public ModelClass(String flightName, Map<String, List> seats) {
		super();
		this.flightName = flightName;
		this.seats = seats;
	}
public ModelClass() {}
@Override
public String toString() {
	return "ModelClass [flightName=" + flightName + ", seats=" + seats + "]";
}

}
