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
import com.rs.eis.model.Perfomance_review;
import com.rs.eis.repository.Perfomance_reviewRepository;
import com.rs.eis.response.AddPerfomance_reviewResponse;
import com.rs.eis.response.DeletePerfomance_reviewResponse;
import com.rs.eis.response.EditPerfomance_reviewResponse;
import com.rs.eis.response.GetPerfomance_reviewResponse;
import com.rs.eis.service.EISService;
import com.rs.eis.validation.ValidationUtil;

@RestController
@RequestMapping("/eis")
public class EISController {
	@Autowired
	EISService eisService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	Perfomance_reviewRepository perfomance_reviewRepository;

	@PostMapping("/perfomance_review")
	public AddPerfomance_reviewResponse addPerfomance_review(@Valid @RequestBody Perfomance_review perfomance_review) {
		return eisService.addPerfomance_review(perfomance_review);
	}

	@GetMapping("/getperfomance_review/{employeeid}")
	public GetPerfomance_reviewResponse getPerfomance_review(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateGetPerfomance_reviewRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetPerfomance_reviewResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getPerfomance_reviewByemployeeid(employeeid);
		}
	}

	@DeleteMapping("/perfomance_review/{employeeid}")
	public DeletePerfomance_reviewResponse deletePerfomance_reviewByemployeeid(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateDeletePerfomance_reviewRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeletePerfomance_reviewResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deletePerfomance_review(employeeid);
		}

	}
	
	@PutMapping("/perfomance_review/{id}")

	public EditPerfomance_reviewResponse editPerfomance_review(@PathVariable("id") int id,
			@Valid @RequestBody Perfomance_review perfomance_review) {
		return eisService.editPerfomance_review(perfomance_review);
}
}
