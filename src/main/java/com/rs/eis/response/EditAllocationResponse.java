package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Allocation;

public class EditAllocationResponse extends AbstractResponse {
	
	private Allocation allocation;
	
	public EditAllocationResponse() {

	}

	public EditAllocationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}


	public Allocation getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}
	
	
	
	
}
