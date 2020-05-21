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

import com.rs.eis.model.Designation;
import com.rs.eis.model.Emp_Designation;
import com.rs.eis.model.Salary;
import com.rs.eis.repository.DesignationRepository;
import com.rs.eis.repository.Emp_DesignationRepository;
import com.rs.eis.repository.SalaryRepository;
import com.rs.eis.response.DeleteDesignationResponse;
import com.rs.eis.response.DeleteEmp_DesignationResponse;
import com.rs.eis.response.DeleteSalaryResponse;
import com.rs.eis.response.DesignationResponse;
import com.rs.eis.response.EditDesignationResponse;
import com.rs.eis.response.EditEmp_DesignationResponse;
import com.rs.eis.response.Emp_DesignationResponse;
import com.rs.eis.response.GetDesignationResponse;
import com.rs.eis.response.GetEmp_DesignationResponse;
import com.rs.eis.response.GetSalaryResponse;
import com.rs.eis.response.SalaryResponse;
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
	DesignationRepository designationRepository;
	@Autowired
	Emp_DesignationRepository emp_designationRepository;
	@Autowired
	SalaryRepository salaryRepository;
	// private int expenseId;

	@PostMapping("/designation")
	public DesignationResponse addDesignation(@Valid @RequestBody Designation designation) {
		return eisService.addDesignation(designation);
	}

	@GetMapping("/designation/{id}")
	public GetDesignationResponse getDesignationById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetDesignationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetDesignationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getDesignationById(id);
		}
	}

	@GetMapping("/emp_designation/{id}")
	public GetEmp_DesignationResponse getEmp_DesignationById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validatePutDesignationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetEmp_DesignationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getemp_DesignationById(id);
		}
	}

	@DeleteMapping("/designation/{id}")
	public DeleteDesignationResponse deleteDesignationById(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationUtil.validateDeleteDesignationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteDesignationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteDesignation(id);
		}
	}

	@DeleteMapping("/emp_designation/{id}")
	public DeleteEmp_DesignationResponse emp_deleteDesignationById(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationUtil.validateDeleteDesignationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteEmp_DesignationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteemp_Designation(id);
		}
	}

	@PutMapping("/designation/{id}")
	public EditDesignationResponse editDesignation(@PathVariable("id") int id,
			@Valid @RequestBody Designation designation) {
		return eisService.editDesignation(designation);
	}

	@PutMapping("/emp_designation/{id}")
	public EditEmp_DesignationResponse editemp_Designation(@PathVariable("id") int id,
			@Valid @RequestBody Emp_Designation emp_designation) {
		return eisService.editemp_Designation(emp_designation);
	}

	@PostMapping("/emp_designation")
	public Emp_DesignationResponse addEmp_Designation(@Valid @RequestBody Emp_Designation emp_designation) {
		return eisService.addemp_designation(emp_designation);
	}

	@PostMapping("/salary")
	public SalaryResponse addSalary(@Valid @RequestBody Salary Salary) {
		return eisService.addSalary(Salary);

	}

	@GetMapping("/salary/{id}")
	public GetSalaryResponse getSalaryById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetDesignationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetSalaryResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getSalaryById(id);
		}
	}
		@DeleteMapping("/salary/{id}")
		public DeleteSalaryResponse deleteSalaryById(@PathVariable(value = "id") int id) {
			Set<String> errorMessages = validationUtil.validateDeleteSalaryRequest(id);
			if (!CollectionUtils.isEmpty(errorMessages)) {
				return new DeleteSalaryResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
			} else {
				return eisService.deletesalary(id);
			}
		}
	/*
	 * @PutMapping("/salary/{id}") public EditDesignationResponse
	 * editSalary(@PathVariable("id") int id,
	 * 
	 * @Valid @RequestBody Salary salary) { return
	 * eisService.editDesignation(designation); } }
	 */
}