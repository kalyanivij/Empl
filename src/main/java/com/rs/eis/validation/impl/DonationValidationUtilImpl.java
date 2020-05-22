package com.rs.eis.validation.impl;

import java.util.HashSet;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.DonationValidationUtil;

@Component
public class DonationValidationUtilImpl implements DonationValidationUtil {

	@Override
	public Set<String> validateGetDonationRequest(int id) {
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
	public Set<String> validateDeleteDonationRequest(int id) {
		return validateGetDonationRequest(id);
	}

}
