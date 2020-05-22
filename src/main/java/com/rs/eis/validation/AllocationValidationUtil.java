package com.rs.eis.validation;

import java.util.Set;


public interface AllocationValidationUtil {

	Set<String> validateDeleteAllocationRequest(int allocationId);

	Set<String> validateGetAllocationRequest(int allocationId);

	Set<String> validateGetAllocationsRequest(int projectId);

}
