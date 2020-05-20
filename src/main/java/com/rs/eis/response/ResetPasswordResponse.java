package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;


public class ResetPasswordResponse extends AbstractResponse {

	public ResetPasswordResponse() {

	}

	public ResetPasswordResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
