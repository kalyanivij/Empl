package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.AllocationValidationUtil;

@Component
public class AllocationValidationUtilImpl implements AllocationValidationUtil {

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

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


	}


