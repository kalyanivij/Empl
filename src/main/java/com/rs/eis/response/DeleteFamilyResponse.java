package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Family;

public class DeleteFamilyResponse extends AbstractResponse {

	public DeleteFamilyResponse() {

	}

	public DeleteFamilyResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Family  Family;

	public Family getFamily() {
		return Family;
	}

	public void setFamily(Family family) {
		Family = family;
	}

	
	

}
