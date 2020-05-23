package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.AddDepartmentVO;

public interface ValidationDepartmentUtil {
	
	Set<String> validateAddDepartmentRequest(AddDepartmentVO addDepartmentVO);

	Set<String> validatePutDepartmentRequest(int id);
	
	Set<String> validateDeleteDepartmentRequest(int id);

	Set<String> validateGetDepartmentRequest(Integer id);

	Set<String> validateGetDepartmentsRequest(Integer userId);
}
