package com.rs.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Timesheet;
import com.rs.eis.repository.AllocationRepository;
import com.rs.eis.repository.TimesheetRepository;
import com.rs.eis.request.TimesheetVO;
import com.rs.eis.response.AddTimesheetResponse;
import com.rs.eis.response.DeleteTimesheetResponse;
import com.rs.eis.response.EditTimesheetResponse;
import com.rs.eis.response.GetTimesheetResponse;
import com.rs.eis.response.GetTimesheetsResponse;
import com.rs.eis.service.TimesheetService;
import com.rs.eis.validation.TimesheetValidationtUtil;

@RestController
@RequestMapping("/eis")
public class TimesheetController {
	@Autowired
	TimesheetService timesheetService;

	@org.springframework.beans.factory.annotation.Autowired(required=false)
	TimesheetValidationtUtil timesheetValidationUtil;

	@Autowired
	TimesheetRepository timesheetRepository;

	@Autowired
	AllocationRepository allocationRepository;

	@PostMapping("/timesheet")
	public AddTimesheetResponse addTimesheet(@ModelAttribute TimesheetVO timesheetVO) {

		Set<String> errorMessages = timesheetValidationUtil.validateAddTimesheetRequest(timesheetVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddTimesheetResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return timesheetService.addTimesheet(timesheetVO);
		}
	}

	@PutMapping("/timesheet/{id}")
	public EditTimesheetResponse editTimesheet(@PathVariable("id") int id,
			@ModelAttribute Timesheet timesheet) {
		return timesheetService.editTimesheet(timesheet);
	}

	@DeleteMapping("/timesheet/{id}")
	public DeleteTimesheetResponse deleteTimesheet(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = timesheetValidationUtil.validateDeleteTimesheetRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteTimesheetResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return timesheetService.deleteTimesheet(id);
		}
	}

	@GetMapping("/timesheet/{id}")
	public GetTimesheetResponse getTimesheet(@PathVariable(value="id") int id) {
		
		Set<String> errorMessages = timesheetValidationUtil.validateGetTimesheetRequest(id);
		
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTimesheetResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return timesheetService.getTimesheet(id);
		}
	}

	@GetMapping("/timesheets/{departmentId}")
	public GetTimesheetsResponse getTimesheets(@PathVariable("departmentId") int departmentId) {
		Set<String> errorMessages = timesheetValidationUtil.validateGetTimesheetsRequest(departmentId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTimesheetsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return timesheetService.getTimesheets(departmentId);
		}
	}
}
