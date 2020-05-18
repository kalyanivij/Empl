package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Employee;
import com.rs.eis.model.Employer;

public class AddEmployerResponse extends AbstractResponse {

	private Employer employer;

	public AddEmployerResponse() {

	}

	public AddEmployerResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

}
