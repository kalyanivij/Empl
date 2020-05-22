package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Emp_awards;

public class GetEmp_awardsResponse extends AbstractResponse {

	public GetEmp_awardsResponse() {

	}

	public GetEmp_awardsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Emp_awards emp_awards;

	public Emp_awards getEmp_awards() {
		return emp_awards;
	}

	public void setEmp_awards(Emp_awards emp_awards) {
		this.emp_awards = emp_awards;
	}

}
