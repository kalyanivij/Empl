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

	private Family  getFamily;

	public Family getGetFamily() {
		return getFamily;
	}

	public void setGetFamily(Family getFamily) {
		this.getFamily = getFamily;
	}

	

}
