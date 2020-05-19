package com.rs.eis.controller;


import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Employer;
import com.rs.eis.repository.EmployerRepository;
import com.rs.eis.request.AddEmployerVO;
import com.rs.eis.response.AddEmployerResponse;
import com.rs.eis.response.EditEmployerResponse;
import com.rs.eis.response.GetEmployeesResponse;
import com.rs.eis.service.EmployerService;
import com.rs.eis.validation.ValidationEmployerUtil;

@RestController
@RequestMapping("/eis")
public class EmployerController {
	@Autowired
	EmployerService employerService;

	@Autowired
	ValidationEmployerUtil validationEmployerUtil;

	@Autowired
	EmployerRepository employerRepository;

	//private int expenseId;

	@PostMapping("/addEmployer")
	public AddEmployerResponse addEmployer(@Valid @RequestBody AddEmployerVO addEmployerVO) {

		Set<String> errorMessages = validationEmployerUtil.validateAddEmployerRequest(addEmployerVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddEmployerResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return employerService.addEmployer(addEmployerVO);
		}
	}

	@PutMapping("/employer/{id}")
	public EditEmployerResponse editEmployer(@PathVariable("id") int iad, @Valid @RequestBody Employer employer) {
		return employerService.editEmployer(employer);
	}

	@GetMapping("/employees/{id}")
	public GetEmployeesResponse getEmployees(@PathVariable("id") int id) {
		Set<String> errorMessages = validationEmployerUtil.validateGetEmployeesRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetEmployeesResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return employerService.getEmployees(id);
		}
	}

}

