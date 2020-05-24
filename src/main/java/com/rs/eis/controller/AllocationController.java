package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Allocation;
import com.rs.eis.repository.AllocationRepository;
import com.rs.eis.request.AllocationVO;
import com.rs.eis.response.AddAllocationResponse;
import com.rs.eis.response.AddTimesheetResponse;
import com.rs.eis.response.DeleteAllocationResponse;
import com.rs.eis.response.EditAllocationResponse;
import com.rs.eis.response.GetAllocationResponse;
import com.rs.eis.response.GetAllocationsResponse;
import com.rs.eis.service.AllocationService;
import com.rs.eis.validation.AllocationValidationUtil;

@RestController
@RequestMapping("/eis")
public class AllocationController {
	@Autowired
	AllocationService allocationService;

	@Autowired
	AllocationValidationUtil allocationUtil;

	@Autowired
	AllocationRepository allocationRepository;

	@PostMapping("/allocation")
	public AddAllocationResponse addAllocation(@Valid @RequestBody AllocationVO allocationVO) {
		Set<String> errorMessages = allocationUtil.validateAddAllocationRequest(allocationVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddAllocationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return allocationService.addAllocation(allocationVO);
		}
	}

	@PutMapping("/allocation")
	public EditAllocationResponse update(@RequestBody Allocation allocation) {
		Set<String> errorMessages = allocationUtil.validateEditAllocationRequest(allocation);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new EditAllocationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return allocationService.editAllocation(allocation);
		}
	}

	@GetMapping("/allocation/{id}")
	public GetAllocationResponse getAllocationById(@PathVariable("id") int id) {
		Set<String> errorMessages = allocationUtil.validateGetAllocationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetAllocationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return allocationService.getAllocationById(id);
		}
	}

	@GetMapping("/allocations/{projectId}")
	public GetAllocationsResponse getAllocations(@PathVariable("projectId") int projectId) {
		Set<String> errorMessages = allocationUtil.validateGetAllocationsRequest(projectId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetAllocationsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return allocationService.getAllocations(projectId);
		}
	}

	@DeleteMapping("/allocation/{allocationId}")
	public DeleteAllocationResponse deleteAllocation(@PathVariable(value = "allocationId") int allocationId) {
		Set<String> errorMessages = allocationUtil.validateDeleteAllocationRequest(allocationId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteAllocationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return allocationService.deleteAllocation(allocationId);
		}

	}
}
