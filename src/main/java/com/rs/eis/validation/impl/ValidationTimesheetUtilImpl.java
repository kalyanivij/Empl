package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.TimesheetVO;
import com.rs.eis.validation.TimesheetValidationtUtil;

@Component
public  class ValidationTimesheetUtilImpl implements TimesheetValidationtUtil {

	@Override
	public Set<String> validateAddTimesheetRequest(TimesheetVO timesheetVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, timesheetVO.getAllocationId(), "Please  enter allocation id");
		addError(errorMessages, timesheetVO.getDay(), "Please enter day");

		addError(errorMessages, timesheetVO.getDepartmentId(), "Please enter department id");
		addError(errorMessages, timesheetVO.getEmployeeId(), "Please enter employee id");
		addError(errorMessages, timesheetVO.getInTime(), "Please enter in time");
		addError(errorMessages, timesheetVO.getOutTime(), "Please enter out time");
		return errorMessages;

	}

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
	public Set<String> validateDeleteTimesheetRequest(int allocationId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, allocationId, "Please enter valid allocationId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetTimesheetRequest(int allocationId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, allocationId, "Please enter valid allocationId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetTimesheetsRequest(int departmentId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, departmentId, "Please enter valid departmentId");

		return errorMessages;
	}
}
