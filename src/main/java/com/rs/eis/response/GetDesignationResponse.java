package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Designation;

public class GetDesignationResponse extends AbstractResponse {
	public GetDesignationResponse() {

	}

	public GetDesignationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Designation designation;

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

}
