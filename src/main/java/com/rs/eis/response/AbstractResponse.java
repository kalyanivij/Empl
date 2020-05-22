package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

public class AbstractResponse {


	private HttpStatus status;

	private String statusCode;

	private String errorMessage;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Set<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Set<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	private Set<String> errorMessages;

	
	

}
