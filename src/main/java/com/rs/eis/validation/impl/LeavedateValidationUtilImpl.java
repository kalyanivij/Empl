package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.LeavedateValidationUtil;

@Component
public class LeavedateValidationUtilImpl implements LeavedateValidationUtil {

	@Override
	public Set<String> validateGetSuffixRequest(int Id) {
			Set<String> errorMessages = new HashSet<String>();

			addError(errorMessages, Id, "Please enter valid Id");

			return errorMessages;
		}
	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}


	@Override
	public Set<String> validateDeleteSuffixRequest(int employeId) {
		return validateGetSuffixRequest(employeId);
	}
	@Override
	public Set<String> validateGetLeave_DataRequest(int Id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, Id, "Please enter valid Id");

		return errorMessages;
	}
    
	
	@Override
	public Set<String> validateDeleteLeave_DataRequest(int employeId) {
		return validateGetSuffixRequest(employeId);
	}
	}

	

