package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Allocation;

public class GetAllocationsResponse extends AbstractResponse {

	public GetAllocationsResponse() {

	}

	public GetAllocationsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private List<Allocation> allocation;

	public List<Allocation> getAllocation() {
		return allocation;
	}

	public void setAllocation(List<Allocation> allocation) {
		this.allocation = allocation;
	}

	
}
