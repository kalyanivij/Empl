package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.ValidationUtil;

@Component
public class ValidationUtilImpl implements ValidationUtil {

	
	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

		public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	
	
		
	@Override
	public Set<String> validatePerfomance_reviewReportRequest(int employeeid) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, employeeid, "Please enter employeeid");
		
		return errorMessages;
	}

	@Override
	public Set<String> validateDeletePerfomance_reviewRequest(int employeeid) {
		return validateGetPerfomance_reviewRequest(employeeid);
	}

	@Override
	public Set<String> validateGetPerfomance_reviewRequest(int reviewid) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, reviewid, "Please enter valid reviewid");

		return errorMessages;

	}

	
}
