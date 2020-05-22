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

import com.rs.eis.model.Experience;
import com.rs.eis.model.Technology;
import com.rs.eis.repository.ExpenseRepository;
import com.rs.eis.response.AddExperienceResponse;
import com.rs.eis.response.AddTechnologyResponse;
import com.rs.eis.response.DeleteTechnologyResponse;
import com.rs.eis.response.EditExperienceResponse;
import com.rs.eis.response.EditTechnologyResponse;
import com.rs.eis.response.GetExperienceResponse;
import com.rs.eis.response.GetTechnologyResponse;
import com.rs.eis.service.FERService;
import com.rs.eis.validation.ValidationUtil;

@RestController
@RequestMapping("/eis")
public class ExperienceController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	ExpenseRepository expenseRepository;

	
	@GetMapping("/experience/{employeeid}")
	public GetExperienceResponse getexperience(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateExperienceRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetExperienceResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getexperience(employeeid);
		}
	}

	@PostMapping("/experience")
	public AddExperienceResponse addexperience(@Valid @RequestBody Experience experience) {
		return ferService.addexperience(experience);
	}

	@PutMapping("/experience/{id}")
	public EditExperienceResponse editexperience(@PathVariable("id") int Id,
			@Valid @RequestBody Experience experience) {
		return ferService.editexperience(experience);
	}

	@GetMapping("/technology/{id}")
	public GetTechnologyResponse gettechnology(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateTechnologyRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTechnologyResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.gettechnology(id);
		}
	}

	@DeleteMapping("/technology/{id}")
	public DeleteTechnologyResponse deleteTechnology(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationUtil.validateDeleteTechnologyRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteTechnologyResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.deletetechnology(id);
		}
	}

	@PostMapping("/technology")
	public AddTechnologyResponse addTechnology(@Valid @RequestBody Technology technology) {
		return ferService.addtechnology(technology);
	}

	@PutMapping("/technology/{id}")
	public EditTechnologyResponse edittechnology(@PathVariable("id") int Id,
			@Valid @RequestBody Technology technology) {
		return ferService.edittechnology(technology);
	}

}
