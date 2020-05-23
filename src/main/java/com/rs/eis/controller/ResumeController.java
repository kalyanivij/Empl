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

import com.rs.eis.model.Resume;
import com.rs.eis.repository.ResumeRepository;
import com.rs.eis.request.ResumeVO;
import com.rs.eis.response.AddResumeResponse;
import com.rs.eis.response.DeleteResumeResponse;
import com.rs.eis.response.EditResumeResponse;
import com.rs.eis.response.GetResumeResponse;
import com.rs.eis.service.ResumeService;
import com.rs.eis.validation.ResumeValidationUtil;

@RestController
@RequestMapping("/api")
public class ResumeController {
	@Autowired
	ResumeService resumeService;

	@Autowired
	ResumeValidationUtil validationUtil;

	@Autowired
	ResumeRepository resumeRepository;

	@PostMapping("/addresume")
	public AddResumeResponse addResume(@Valid @RequestBody ResumeVO resumeVO) {
		Set<String> errorMessages = validationUtil.validateAddResumeRequest(resumeVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddResumeResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return resumeService.addResume(resumeVO);
		}
	}

	@PutMapping("/resume/{id}")
	public EditResumeResponse editResume(@PathVariable("id") int Id, @Valid @RequestBody Resume resume) {
		return resumeService.editResume(resume);
	}

	@DeleteMapping("/resume/{resumeId}")
	public DeleteResumeResponse deleteAllocation(@PathVariable(value = "resumeId") int resumeId) {
		Set<String> errorMessages = validationUtil.validateDeleteResumeRequest(resumeId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteResumeResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return resumeService.deleteResume(resumeId);
		}

	}

	@GetMapping("/resume/{employeeid}")
	public GetResumeResponse getResume(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateGetResumeRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetResumeResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return resumeService.getResume(employeeid);
		}
	}

}