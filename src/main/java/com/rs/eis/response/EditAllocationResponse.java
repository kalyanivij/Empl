package com.rs.eis.response;

import com.rs.eis.model.Allocation;

public class EditAllocationResponse extends AbstractResponse {
	
	private Allocation allocation;

	public Allocation getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}
	
	
	
	
}
