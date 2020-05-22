package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
import com.rs.eis.validation.ValidationUtil;

@Component
public class ValidationUtilImpl implements ValidationUtil {

<<<<<<< HEAD
	
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

	
	
		
=======
	public static Set<String> addError(Set<String> errorMessages, int emp_awardsid, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(emp_awardsid)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
	@Override
<<<<<<< HEAD
	public Set<String> validatePerfomance_reviewReportRequest(int employeeid) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, employeeid, "Please enter employeeid");
		
		return errorMessages;
=======
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
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
	}

<<<<<<< HEAD
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

	
=======
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
}
