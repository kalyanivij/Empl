package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.AddEmployerVO;
import com.rs.eis.validation.ValidationEmployerUtil;

@Component
public class ValidationEmployerUtilImpl implements ValidationEmployerUtil {

	@Override
	public Set<String> validateAddEmployerRequest(AddEmployerVO addEmployerVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, addEmployerVO.getName(), "Please enter EmployerName");
		addError(errorMessages, addEmployerVO.getCampus(), "Please enter Campus");
		addError(errorMessages, addEmployerVO.getBranch(), "Please enter Branch");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetEmployeesRequest(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid employerId");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

}
