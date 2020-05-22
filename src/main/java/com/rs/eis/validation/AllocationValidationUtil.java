package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.AllocationVO;

public interface AllocationValidationUtil {

	Set<String> validateAddAllocationRequest(AllocationVO allocationVO);

	Set<String> validateDeleteAllocationRequest(int allocationId);

	Set<String> validateGetAllocationRequest(int allocationId);

	Set<String> validateGetAllocationsRequest(int projectId);

}
