package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Salary;

public class DeleteSalaryResponse extends AbstractResponse {

	private Salary salary;

	public Salary getSalary() {
		return salary;
	}

	public void setDesignation(Salary salary) {
		this.salary = salary;
	}

	public DeleteSalaryResponse() {

	}

	public DeleteSalaryResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
