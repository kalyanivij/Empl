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
import com.rs.eis.response.DeleteAllocationResponse;
import com.rs.eis.response.EditAllocationResponse;
import com.rs.eis.response.GetAllocationResponse;
import com.rs.eis.response.GetAllocationsResponse;
import com.rs.eis.service.EISService;
import com.rs.fer.validation.ValidationUtil;

@RestController
@RequestMapping("/api")
public class AllocationController {
	@Autowired
	EISService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	AllocationRepository allocationRepository;

	@PostMapping("/allocation")
	public AddAllocationResponse addAllocation(@Valid @RequestBody AllocationVO allocationVO) {
		return ferService.addAllocation(allocationVO);
	}

	@PutMapping("/allocation/{id}")
	public EditAllocationResponse editAllocation(@PathVariable("id") int Id,
			@Valid @RequestBody Allocation allocation) {
		return ferService.editAllocation(allocation);
	}

	@GetMapping("/allocation/{id}")
	public GetAllocationResponse getAllocationById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetAllocationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetAllocationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getAllocationById(id);
		}
	}

	@GetMapping("/allocations/{projectId}")
	public GetAllocationsResponse getAllocations(@PathVariable("projectId") int projectId) {
		Set<String> errorMessages = validationUtil.validateGetAllocationsRequest(projectId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetAllocationsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getAllocations(projectId);
		}
	}

	@DeleteMapping("/allocation/{allocationId}")
	public DeleteAllocationResponse deleteAllocation(@PathVariable(value = "allocationId") int allocationId) {
		Set<String> errorMessages = validationUtil.validateDeleteAllocationRequest(allocationId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteAllocationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.deleteAllocation(allocationId);
		}

	}
}
