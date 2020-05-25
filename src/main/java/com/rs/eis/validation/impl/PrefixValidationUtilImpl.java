package com.rs.eis.validation.impl;


import java.util.HashSet;

import java.util.Set;

import com.rs.eis.validation.PrefixValidationUtil;


public class PrefixValidationUtilImpl  implements PrefixValidationUtil{

	@Override
	public Set<String> validateGetPrefixRequest(int Id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, Id, "Please enter valid Id");

		return errorMessages;
	}

		private Set<String> addError(Set<String> errorMessages, int value,  String errorMessage) {
		
	
		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
		}
		@Override
	public Set<String> validateDeletePrefixRequest(int employeId) {
			return validateGetPrefixRequest(employeId);
			}

}
