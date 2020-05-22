package com.rs.eis.response;

import com.rs.eis.model.Timesheet;

public class EditTimesheetResponse extends AbstractResponse {

	private Timesheet timesheet;

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}

	

}
