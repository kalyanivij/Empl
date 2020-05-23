package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Departments;

public class DeleteDepartmentResponse extends AbstractResponse {
	
	private Departments department;
	
	public DeleteDepartmentResponse() {
		
	}
	
	public DeleteDepartmentResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}
	
	
	
	
}
