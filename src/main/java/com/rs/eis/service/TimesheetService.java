package com.rs.eis.service;

import com.rs.eis.model.Timesheet;
import com.rs.eis.request.TimesheetVO;
import com.rs.eis.response.AddTimesheetResponse;
import com.rs.eis.response.DeleteTimesheetResponse;
import com.rs.eis.response.EditTimesheetResponse;
import com.rs.eis.response.GetTimesheetResponse;
import com.rs.eis.response.GetTimesheetsResponse;

public interface TimesheetService {
	
	// AddTimesheetResponse AddTimesheet(com.rs.fer.model.Timesheet timesheet);

	// com.rs.fer.response.DeleteTimesheetResponse deleteTimesheet(int timesheetId);

	//GetTimesheetResponse getTimesheet(int allocationId);


	EditTimesheetResponse editTimesheet(Timesheet timesheet);

	GetTimesheetResponse getTimesheet(int allocationId);

	DeleteTimesheetResponse deleteTimesheet(int allocationId);

	AddTimesheetResponse addTimesheet( TimesheetVO timesheetVO);

	GetTimesheetsResponse getTimesheets(int departmentId);


}
