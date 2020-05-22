package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Family;
import com.rs.eis.model.Insurance;

public class FamilyResponse extends AbstractResponse {

	private Family family;

	public FamilyResponse() {

	}

	public FamilyResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Family getfamily() {
		return family;
	}

	public void setfamily(Family family) {
		this.family = family;
	}

	
}
