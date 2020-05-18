package com.rs.eis.response;

import java.util.List;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Employee;

public class GetEmployeesResponse extends AbstractResponse {

	public GetEmployeesResponse() {

	}

	public GetEmployeesResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
