package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import com.rs.eis.request.ResumeVO;
import com.rs.eis.validation.ResumeValidationUtil;

public class ResumeValidationUtillImpl implements ResumeValidationUtil {

	public static Set<String> addError(Set<String> errorMessages, Object value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}
	
	@Override
	public Set<String> validateAddResumeRequest(ResumeVO resumeVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, resumeVO.getId(), "Please  enter Resume id");
		addError(errorMessages, resumeVO.getNewResume(), "Please New Resume");

		addError(errorMessages, resumeVO.getEmployeeId(), "Please enter Employee id");
		
		return errorMessages;

	}

	@Override
	public Set<String> validateDeleteResumeRequest(int resumeId) {
		return validateGetResumeRequest(resumeId);
	}

	@Override
	public Set<String> validateGetResumeRequest(int employeeId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, employeeId, "Please enter valid employeeId");

		return errorMessages;
	}

	

}
