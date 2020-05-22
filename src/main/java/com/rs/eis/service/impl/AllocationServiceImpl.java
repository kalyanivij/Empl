package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.rs.eis.model.Allocation;
import com.rs.eis.model.Project;
import com.rs.eis.model.Timesheet;
import com.rs.eis.repository.AllocationRepository;
import com.rs.eis.repository.ProjectRepository;
import com.rs.eis.request.AllocationVO;
import com.rs.eis.response.AddAllocationResponse;
import com.rs.eis.response.DeleteAllocationResponse;
import com.rs.eis.response.EditAllocationResponse;
import com.rs.eis.response.GetAllocationResponse;
import com.rs.eis.response.GetAllocationsResponse;
import com.rs.eis.service.AllocationService;
import com.rs.eis.util.AllocationUtil;
import com.rs.eis.util.DateUtil;
import com.rs.eis.util.TimeSheetUtil;

public class AllocationServiceImpl implements AllocationService {

	@Autowired
	AllocationRepository allocationRepository;
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public AddAllocationResponse addAllocation(AllocationVO allocationVO) {
		AddAllocationResponse response = new AddAllocationResponse();
		Optional<Allocation> projectObj = allocationRepository.findById(allocationVO.getProjectid());
		
		if (projectObj.isPresent()) {
			Allocation allocation = AllocationUtil.loadAllocationVOToAllocationn(allocationVO);

			allocation.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

			allocation = allocationRepository.save(allocation);

			response.setAllocation(allocation);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid allocation as projectId is not present in Project table");
		}

		return response;
	}

	@Override
	public EditAllocationResponse editAllocation(Allocation allocation) {
		EditAllocationResponse response = new EditAllocationResponse();

		Optional<Allocation> allocationObj = allocationRepository.findById(allocation.getId());

		if (allocationObj.isPresent()) {

			allocation.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			allocation = allocationRepository.save(allocation);

			response.setAllocation(allocation);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as allocationId is not present in allocation table");
		}

		return response;

	}

	@Override
	public DeleteAllocationResponse deleteAllocation(int projectid) {
		DeleteAllocationResponse response = new DeleteAllocationResponse();

		Optional<Allocation> allocationObj = allocationRepository.findById(projectid);

		if (allocationObj.isPresent()) {
			Allocation allocation = allocationObj.get();
			allocationRepository.delete(allocation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as allocationId is not present in allocation table");
		}

		return response;

	}

	@Override
	public GetAllocationResponse getAllocationById(int id) {
		GetAllocationResponse response = new GetAllocationResponse();
		Optional<Allocation> allocationObj = allocationRepository.findById(id);
		if (allocationObj.isPresent()) {
			response.setAllocation(allocationObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No allocation Found for the given allocationid");
		}

		return response;

	}

	@Override
	public GetAllocationsResponse getAllocations(int projectid) {
		GetAllocationsResponse response = new GetAllocationsResponse();
		List<Allocation> allocations = allocationRepository.findByProjectid(projectid);
		if (!allocations.isEmpty()) {
			response.setAllocation(allocations);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as projectId is not present in allocation table");
		}

		return response;
	}

}
