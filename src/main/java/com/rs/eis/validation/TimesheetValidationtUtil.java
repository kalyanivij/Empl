package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.TimesheetVO;

public interface TimesheetValidationtUtil {

	Set<String> validateDeleteTimesheetRequest(int allocationId);

	Set<String> validateGetTimesheetRequest(int allocationId);

	//Set<String> validateGetTimesheetsRequest(int employeeId);

	Set<String> validateAddTimesheetRequest(TimesheetVO timesheetVO);

	Set<String> validateGetTimesheetsRequest(int departmentId);


}
