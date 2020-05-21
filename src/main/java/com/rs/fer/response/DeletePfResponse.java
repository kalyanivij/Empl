package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Pf;

public class DeletePfResponse extends AbstractResponse {

	private Pf pf;

	public Pf getPf() {
		return pf;
	}

	public void setPf(Pf pf) {
		this.pf = pf;
	}

	public DeletePfResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public DeletePfResponse() {
	}
}
