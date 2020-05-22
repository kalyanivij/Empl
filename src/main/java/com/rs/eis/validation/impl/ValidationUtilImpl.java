package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.ValidationUtil;

@Component
public class ValidationUtilImpl implements ValidationUtil {

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteStateRequest(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetStateRequest(int id) {
		return validateDeleteStateRequest(id);
	}

	@Override
	public Set<String> validateGetStateRequest1(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateStateRequest(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	



	}


