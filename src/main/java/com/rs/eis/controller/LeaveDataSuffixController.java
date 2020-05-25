package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Leave_Data;
import com.rs.eis.model.Suffix;
import com.rs.eis.repository.Leave_DataRepository;
import com.rs.eis.repository.SuffixRepository;
import com.rs.eis.response.DeleteLeave_DataResponse;
import com.rs.eis.response.DeleteSuffixResponse;
import com.rs.eis.response.EditLeave_DataResponse;
import com.rs.eis.response.EditSuffixResponse;
import com.rs.eis.response.GetLeave_DataResponse;
import com.rs.eis.response.GetSuffixResponse;
import com.rs.eis.response.Leave_DataResponse;
import com.rs.eis.response.SuffixResponse;
import com.rs.eis.service.LeavedataSuffixService;
import com.rs.eis.validation.LeavedateValidationUtil;


@RestController
@RequestMapping("/api")
public class LeaveDataSuffixController {
	@Autowired
	LeavedataSuffixService eisService;

	@Autowired
	LeavedateValidationUtil validationUtil;

	@Autowired
	Leave_DataRepository leave_DataRepository;
	
	@Autowired
	SuffixRepository suffixRepository;

	
	@PostMapping("/addsuffix")
	public SuffixResponse suffix(@Valid @RequestBody Suffix suffix) {
		return eisService.suffix(suffix);
	}
	
	@PutMapping("/suffix/{id}")
	public EditSuffixResponse editSuffix(@PathVariable("id") int Id, @Valid @RequestBody Suffix suffix) {
		return eisService.editSuffix(suffix);
	}

	@GetMapping("/suffix/{id}")
	public GetSuffixResponse getSuffixById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetSuffixRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetSuffixResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getSuffixById(id);
		}
	}
	
	@DeleteMapping("/suffix/{employeId}")
	public DeleteSuffixResponse deleteSuffix(@PathVariable(value = "employeId") int employeId) {
		Set<String> errorMessages = validationUtil.validateDeleteSuffixRequest(employeId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteSuffixResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteSuffix(employeId);
		}
	}
	
	@PostMapping("/leave_Data")
	public Leave_DataResponse leave_Data(@Valid @RequestBody Leave_Data leave_Data) {
		return eisService.leave_Data(leave_Data);
	}
	
	@PutMapping("/leave_Data/{id}")
	public EditLeave_DataResponse editLeave_Data(@PathVariable("id") int Id, @Valid @RequestBody Leave_Data leave_Data) {
		return eisService.editLeave_Data(leave_Data);
	}
	
	@GetMapping("/leave_Data/{id}")
	public GetLeave_DataResponse getLeave_DataById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetLeave_DataRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetLeave_DataResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getLeave_DataById(id);
		}
	}
	
	@DeleteMapping("/leave_Data/{employeId}")
	public DeleteLeave_DataResponse deleteLeave_Data(@PathVariable(value = "employeId") int employeId) {
		Set<String> errorMessages = validationUtil.validateDeleteLeave_DataRequest(employeId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteLeave_DataResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteLeave_Data(employeId);
		}
	}
	

}
