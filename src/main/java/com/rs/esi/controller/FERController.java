package com.rs.esi.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.esi.model.Perfomance_Review;
import com.rs.esi.repository.ExpenseRepository;
import com.rs.esi.repository.Perfomance_reviewRepository;
import com.rs.esi.request.RegistrationVO;
import com.rs.esi.response.AddPerfomance_reviewResponse;
import com.rs.esi.response.DeletePerfomance_reviewResponse;
import com.rs.esi.response.GetPerfomance_reviewResponse;
import com.rs.esi.response.LoginResponse;
import com.rs.esi.response.RegistrationResponse;
import com.rs.esi.service.FERService;
import com.rs.esi.validation.ValidationUtil;


@RestController
@RequestMapping("/api")
public class FERController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	Perfomance_reviewRepository perfomance_reviewRepository;


	private int expenseId;

	@PostMapping("/register")
	
	public RegistrationResponse userRegistration(@Valid @RequestBody RegistrationVO registrationVO) {

		Set<String> errorMessages = validationUtil.validateRegistrationRequest(registrationVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.registration(registrationVO);
		}
	}

		
	
	   @PostMapping("/perfomance_review") public AddPerfomance_reviewResponse
	   addPerfomance_review(@Valid @RequestBody Perfomance_Review perfomance_review) { return
	   ferService.addPerfomance_review(perfomance_review); }
	  

	@GetMapping("/getperfomance_review/{employeeid}")
	public GetPerfomance_reviewResponse getPerfomance_review(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateGetPerfomance_reviewRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetPerfomance_reviewResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getPerfomance_reviewByemployeeid(employeeid);
		}
	}

	@GetMapping("/{employeeid}/perfomance_review/report")
	public GetPerfomance_reviewResponse perfomance_reviewReport(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validatePerfomance_reviewReportRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetPerfomance_reviewResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.perfomance_reviewReport(employeeid);
		}
	}
	
	
	@DeleteMapping("/perfomance_review/{employeeid}")
	public DeletePerfomance_reviewResponse deletePerfomance_review(@PathVariable(value = "employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateDeletePerfomance_reviewRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeletePerfomance_reviewResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.deletePerfomance_review(employeeid);
		}

	
	
}
}
