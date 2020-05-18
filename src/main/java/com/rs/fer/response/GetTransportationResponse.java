package com.rs.fer.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Expense;

public class GetTransportationResponse extends AbstractResponse{
	
	
	public GetTransportationResponse() {

	}

	public GetTransportationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}
	
	
	

	

}
