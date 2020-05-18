package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
import com.rs.eis.util.TimeSheetUtil;
import com.rs.eis.validation.TimesheetValidationtUtil;

@Service
public class TimesheetServiceImpl implements TimesheetService {
	@Autowired
	TimesheetRepository timesheetRepository;

	@Autowired
	TimesheetService timesheetService;

	@Autowired
	TimesheetValidationtUtil TimesheetValidationtUtil;

	@Autowired
	AllocationRepository allocationRepository;

	@Override
	public AddTimesheetResponse addTimesheet(TimesheetVO timesheetVO) {
		AddTimesheetResponse response = new AddTimesheetResponse();
		/*
		 * List<Timesheet> timesheets =
		 * timesheetRepository.findByAllocationId(timesheetVO.getAllocationId());
		 * 
		 * if (CollectionUtils.isEmpty(timesheets)) {
		 */

		Optional<Timesheet> timesheets = timesheetRepository.findByallocationId(timesheetVO.getAllocationId());

		if (!timesheets.isPresent()) {

			Timesheet timesheet = TimeSheetUtil.loadTimesheetVOToTimesheet(timesheetVO);

			timesheet = timesheetRepository.save(timesheet);

			response.setTimesheet(timesheet);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Allocation Id Duplicate");

		}

		return response;
	}

	@Override
	public EditTimesheetResponse editTimesheet(Timesheet timesheet) {
		EditTimesheetResponse response = new EditTimesheetResponse();

		Optional<Timesheet> timesheets = timesheetRepository.findByallocationId(timesheet.getAllocationId());

		if (timesheets.isPresent()) {

			timesheet = timesheetRepository.save(timesheet);

			response.setTimesheet(timesheet);
			

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as AllocationId is not present in timesheeet table");
		}

		return response;
	}

	@Override
	public GetTimesheetResponse getTimesheet(int allocationId) {
		GetTimesheetResponse response = new GetTimesheetResponse();
		
		Optional<Timesheet> tsObj = timesheetRepository.findByallocationId(allocationId);
		
		if (tsObj.isPresent()) {
			response.setTimesheet(tsObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No timesheet Found for the given allocationId");
		}

		return response;
	}

	@Override
	public DeleteTimesheetResponse deleteTimesheet(int allocationId) {
		DeleteTimesheetResponse response = new DeleteTimesheetResponse();

		Optional<Timesheet> tsObj = timesheetRepository.findByallocationId(allocationId);

		if (tsObj.isPresent()) {
			Timesheet timesheet = tsObj.get();

			timesheetRepository.delete(timesheet);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in timesheet table");

		}

		return response;
	}

	@Override
	public GetTimesheetsResponse getTimesheets(int departmentId) {
		GetTimesheetsResponse response = new GetTimesheetsResponse();
		List<Timesheet> tsObjs = timesheetRepository.findByDepartmentId(departmentId);
		if (!CollectionUtils.isEmpty(tsObjs)) {
			response.setTimesheets(tsObjs);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No timesheet Found for the given departmentId");
		}

		return response;
	}

}
