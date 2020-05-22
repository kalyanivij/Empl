package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.CertificationVO;
import com.rs.eis.validation.CertificationValidationUtil;

@Component
public class CertificationValidationUtilImpl implements CertificationValidationUtil {

	@Override
	public Set<String> validateSaveCertificationRequest(CertificationVO certificationVO) {

		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, certificationVO.getEmployeeId(), "Please enter EmployeeId");
		addError(errorMessages, certificationVO.getEmployerId(), "Please enter EmloyerId");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, int i, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(i)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteCertificationRequest(int certificationId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, certificationId, "Please enter valid certificationId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetCertificationRequest(int certificationId) {

		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, certificationId, "Please enter valid certificationId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetCertificationsRequest(int employeeId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, employeeId, "Please enter valid employeeId");

		return errorMessages;
	}
}
