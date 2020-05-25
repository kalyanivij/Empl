package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.ContactVO;
import com.rs.eis.validation.ContactValidationUtil;

@Component
public class ContactValidationUtilImpl implements ContactValidationUtil {

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateSaveContactEmployeeRequest(ContactVO contactVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, contactVO.getEmployeeId(), "Please enter EmployeeId");

		return errorMessages;

	}

	@Override
	public Set<String> validateSaveContactEmployerRequest(ContactVO contactVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, contactVO.getEmployerId(), "Please enter EmployerId");

		return errorMessages;

	}

	@Override
	public Set<String> validateDeleteContactRequest(int contactId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, contactId, "Please enter valid contactId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetContactRequest(int employeeId) {
		return validateDeleteContactRequest(employeeId);
	}

	@Override
	public Set<String> validateGetContactsRequest(int employerId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, employerId, "Please enter employerId");

		return errorMessages;
	}

}
