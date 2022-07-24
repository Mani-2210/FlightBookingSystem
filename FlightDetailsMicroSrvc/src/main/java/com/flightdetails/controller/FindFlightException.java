package com.flightdetails.controller;

public class FindFlightException extends RuntimeException{
	public FindFlightException() {
		super("Cannot find flight with this id");
	}

	@Override
	public String toString() {
		return "Cannot find flight with this id";
	}
	

}
