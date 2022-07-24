package com.bookingdetails.model;

public class ResponseClass {
private String flightName;
private String from;
private String to;
private String passName;

public ResponseClass() {}
public String getFlightName() {
	return flightName;
}
public void setFlightName(String flightName) {
	this.flightName = flightName;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getPassName() {
	return passName;
}
public void setPassName(String passName) {
	this.passName = passName;
}
public ResponseClass(String flightName, String from, String to, String passName) {
	super();
	this.flightName = flightName;
	this.from = from;
	this.to = to;
	this.passName = passName;
}

}
