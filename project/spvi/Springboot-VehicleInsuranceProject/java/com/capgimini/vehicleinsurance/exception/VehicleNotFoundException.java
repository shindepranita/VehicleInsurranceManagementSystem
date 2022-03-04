package com.capgimini.vehicleinsurance.exception;

public class VehicleNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VehicleNotFoundException(String errorMessage) {
		super( errorMessage);
		//this.errorMessage = errorMessage;
	}
}
