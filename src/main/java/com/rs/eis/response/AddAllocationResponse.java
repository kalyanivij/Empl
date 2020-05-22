package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Allocation;

public class AddAllocationResponse extends AbstractResponse {
	
	private Allocation allocation;
	
	public Allocation getAllocation() {
		return allocation;
	}
	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}
	
	public AddAllocationResponse() {

	}

	public AddAllocationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);

	}

	
}
