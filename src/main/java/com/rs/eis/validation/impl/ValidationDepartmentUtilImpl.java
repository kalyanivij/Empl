package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.AddDepartmentVO;
import com.rs.eis.validation.ValidationDepartmentUtil;

@Component
public class ValidationDepartmentUtilImpl implements ValidationDepartmentUtil {

	@Override
	public Set<String> validateAddDepartmentRequest(AddDepartmentVO addDepartmentVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, addDepartmentVO.getName(), "Please enter Name");
		addError(errorMessages, addDepartmentVO.getEmployerid(), "Please enter Employerid");
		
		
		

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validatePutDepartmentRequest(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid employeeId");

		return errorMessages;
	}

	public static Set<String> addError1(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteDepartmentRequest(int id) {
		
		return validateGetDepartmentRequest(id);
	}

	@Override
	public Set<String> validateGetDepartmentRequest(Integer id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid Id");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetDepartmentsRequest(Integer id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid id");

		return errorMessages;
	
	}

	

	
	
	
}
