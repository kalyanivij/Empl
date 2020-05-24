package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.model.Allocation;
import com.rs.eis.request.AllocationVO;
import com.rs.eis.validation.AllocationValidationUtil;

@Component
public class AllocationValidationUtilImpl implements AllocationValidationUtil {

	public static Set<String> addError(Set<String> errorMessages, Object value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateAddAllocationRequest(AllocationVO allocationVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, allocationVO.getName(), "Please enter Name");
		addError(errorMessages, allocationVO.getProjectid(), "Please enter ProjectId");

		return errorMessages;

	}

	@Override
	public Set<String> validateDeleteAllocationRequest(int allocationId) {
		return validateGetAllocationRequest(allocationId);
	}

	@Override
	public Set<String> validateGetAllocationRequest(int allocationId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, allocationId, "Please enter valid allocationId");

		return errorMessages;

	}

	@Override
	public Set<String> validateGetAllocationsRequest(int projectId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, projectId, "Please enter valid projectId");

		return errorMessages;

	}

	@Override
	public Set<String> validateEditAllocationRequest(Allocation allocation) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, allocation.getName(), "Please enter Name");
		addError(errorMessages, allocation.getProjectid(), "Please enter ProjectId");

		return errorMessages;
	}

}
