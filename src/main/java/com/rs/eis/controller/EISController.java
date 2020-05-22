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

import com.rs.eis.model.Emp_awards;
import com.rs.eis.repository.Emp_awardsRepository;
import com.rs.eis.response.AddEmp_awardsResponse;
import com.rs.eis.response.DeleteEmp_awardsResponse;
import com.rs.eis.response.EditEmp_awardsResponse;
import com.rs.eis.response.GetEmp_awardsResponse;
import com.rs.eis.service.EISService;
import com.rs.eis.validation.ValidationUtil;

@RestController
@RequestMapping("/api")
public class EISController {
	@Autowired
	EISService eisService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	Emp_awardsRepository emp_awardsRepository;

	@PostMapping("/emp_awards")

	public AddEmp_awardsResponse addEmp_awards(@Valid @RequestBody Emp_awards emp_awards) {
		return eisService.addEmp_awards(emp_awards);
	}

	@GetMapping("/emp_awards/{emp_awardsid}")
	public GetEmp_awardsResponse getEmp_awards(@PathVariable("emp_awardsid") int emp_awardsid) {
		Set<String> errorMessages = validationUtil.validateGetEmp_awardsRequest(emp_awardsid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetEmp_awardsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getEmp_awardsByemployeeid(emp_awardsid);
		}
	}

	@PutMapping("/emp_awards/{id}")

	public EditEmp_awardsResponse editEmp_awards(@PathVariable("id") int id,
			@Valid @RequestBody Emp_awards emp_awards) {
		return eisService.editEmp_awards(emp_awards);
	}

	@GetMapping("/emp_awardss/{employeeid}")
	public GetEmp_awardsResponse getEmp_awards(@PathVariable("employeeid") Integer employeeid) {
		Set<String> errorMessages = validationUtil.validateGetEmp_awardsRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetEmp_awardsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getEmp_awardsByemployeeid(employeeid);
		}
	}

	@DeleteMapping("/emp_awards/{id}")
	public DeleteEmp_awardsResponse deleteEmp_awardsByid(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateDeleteEpm_awardsRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteEmp_awardsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteEmp_awards(id);
		}
	}

}
