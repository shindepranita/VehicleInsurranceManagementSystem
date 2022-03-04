package com.capgimini.vehicleinsurance.exception;

import org.springframework.stereotype.Component;

@Component
public class InsuranceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public InsuranceNotFoundException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

public InsuranceNotFoundException() {
		
	}
}
