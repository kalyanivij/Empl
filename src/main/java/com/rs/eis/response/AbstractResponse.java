package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

public class AbstractResponse {

	private HttpStatus Status;

	private String StatusCode;

	private String errorMessage;

	Set<String> errorMassages;

	public Set<String> getErrorMassages() {
		return errorMassages;
	}

	public void setErrorMassages(Set<String> errorMassages) {
		this.errorMassages = errorMassages;
	}

	public HttpStatus getStatus() {
		return Status;
	}

	public void setStatus(HttpStatus status) {
		Status = status;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
