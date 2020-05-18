package com.rs.eis.response;

import java.util.Set;


import org.springframework.http.HttpStatus;

import com.rs.eis.model.Employee;

public class AddEmployeeResponse extends AbstractResponse {

	private Employee employee;

	public AddEmployeeResponse() {

	}

	public AddEmployeeResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
