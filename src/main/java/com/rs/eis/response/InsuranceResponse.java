package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Insurance;

public class InsuranceResponse extends AbstractResponse {

	private Insurance insurance;

	public InsuranceResponse() {

	}

	public InsuranceResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Insurance getinsurance() {
		return insurance;
	}

	public void setinsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	
}
