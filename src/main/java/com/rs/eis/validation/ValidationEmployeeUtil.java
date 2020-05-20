package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.AddEmployeeVO;

public interface ValidationEmployeeUtil {
	Set<String> validateAddEmployeeRequest(AddEmployeeVO addemployeeVO);

	Set<String> validateGetEmployeeRequest(int id);

	Set<String> validateEditEmployeeRequest(int id);

	Set<String> validateDeleteEmployeeRequest(int id);

	// Set<String> validateUpdateEmployeeRequest(EmployeeVO employeeVO);
}
