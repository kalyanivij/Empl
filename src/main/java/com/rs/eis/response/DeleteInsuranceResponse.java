package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Insurance;

public class DeleteInsuranceResponse extends AbstractResponse {

	public DeleteInsuranceResponse() {

	}

	public DeleteInsuranceResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Insurance  Insurance;

	public Insurance getInsurance() {
		return Insurance;
	}

	public void setInsurance(Insurance insurance) {
		Insurance = insurance;
	}

	

	

}
