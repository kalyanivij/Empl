package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Expense;
import com.rs.fer.model.Transportation;

public class DeleteTransportationResponse extends AbstractResponse {

	private Transportation transportation;

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	public DeleteTransportationResponse() {

	}

	public DeleteTransportationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}


}
