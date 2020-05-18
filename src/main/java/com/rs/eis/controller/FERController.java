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



import com.rs.eis.model.Qualification;
import com.rs.eis.request.QualificationVO;
import com.rs.eis.response.DeleteQualificationResponse;
import com.rs.eis.response.EditQualificationResponse;
import com.rs.eis.response.GetQualificationResponse;
import com.rs.eis.response.QualificationResponse;
import com.rs.eis.service.FERService;
import com.rs.eis.validation.ValidationUtil;

@RestController
@RequestMapping("/api")
public class FERController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@PostMapping("/qualification")
	public QualificationResponse employeeQualification(@Valid @RequestBody QualificationVO qualificationVO) {

		Set<String> errorMessages = validationUtil.validateQualificationRequest(qualificationVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new QualificationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.InsertQualification(qualificationVO);
		}
	}
	

	@GetMapping("/qualification/{id}")
	public GetQualificationResponse getQualificationById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetQualificatuonRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetQualificationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getQualififcationById(id);
		}
	}

	@DeleteMapping("/qualification/{id}")
	public DeleteQualificationResponse deleteQualification(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationUtil.validateDeleteQualificationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteQualificationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.deleteQualification(id);
		}
	}

	@PutMapping("/qualification/{id}")
	public EditQualificationResponse editQualification(@PathVariable("id") int Id,
			@Valid @RequestBody Qualification qualification) {
		return ferService.editQualification(qualification);
	}

}
