package com.rs.eis.service;

import com.rs.eis.model.Allocation;
import com.rs.eis.response.AddAllocationResponse;
import com.rs.eis.response.DeleteAllocationResponse;
import com.rs.eis.response.EditAllocationResponse;
import com.rs.eis.response.GetAllocationResponse;
import com.rs.eis.response.GetAllocationsResponse;

public interface AllocationService {

	AddAllocationResponse addAllocation(Allocation allocation);
	//AddAllocationResponse addAllocation(AllocationVO allocationVO);

	EditAllocationResponse editAllocation(Allocation allocation);

	DeleteAllocationResponse deleteAllocation(int projectid);

	GetAllocationResponse getAllocationById(int id);

	GetAllocationsResponse getAllocations(int projectid);
}
