package com.rs.fer.response;

import java.util.List;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Pf;

public class GetPfResponse extends AbstractResponse {

	public GetPfResponse() {

	}

	public GetPfResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Pf pf;

	public Pf getPf() {
		return pf;
	}

	public void setPf(Pf pf) {
		this.pf = pf;
	}

}
