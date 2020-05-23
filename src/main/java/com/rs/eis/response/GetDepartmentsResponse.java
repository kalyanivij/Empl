package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Departments;

public class GetDepartmentsResponse extends AbstractResponse {
	
	private Departments department;
	
	public GetDepartmentsResponse() {
		
	}
	
	public GetDepartmentsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
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
	

	public void setDepartment1(Departments departments) {
		this.department = departments;
		
	}

	public List<Departments> setDepartment(List<Departments> departments) {
		return  departments;
		
	}
	
	
	
	
}
