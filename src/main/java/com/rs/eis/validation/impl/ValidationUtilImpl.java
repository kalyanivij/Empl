package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.ValidationUtil;

@Component
public class ValidationUtilImpl implements ValidationUtil {

	public static Set<String> addError(Set<String> errorMessages, int emp_awardsid, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(emp_awardsid)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetEmp_awardsRequest(int emp_awardsid) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, emp_awardsid, "Please enter valid emp_id");

		return errorMessages;
	}

//	@Override
//	public Set<String> validateEmp_awardsReportRequest(int employeeid) {
//		// TODO Auto-generated method stub
//		Set<String> errorMessages = new HashSet<String>();
//
//		addError(errorMessages, employeeid, "Please enter employeeid");
//		
//		return errorMessages;
//	}

	@Override
	public Set<String> validateDeleteEpm_awardsRequest(int id) {
		// TODO Auto-generated method stub
		return validateGetEmp_awardsRequest(id);
	}

	@Override
	public Set<String> validateGetAllEmp_awardsRequest(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
