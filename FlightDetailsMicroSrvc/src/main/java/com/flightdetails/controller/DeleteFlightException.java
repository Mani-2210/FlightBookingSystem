package com.flightdetails.controller;

public class DeleteFlightException extends RuntimeException{
public DeleteFlightException() {
	super("Invalid Id");
}

@Override
public String toString() {
	return "Invalid Id";
}

}
