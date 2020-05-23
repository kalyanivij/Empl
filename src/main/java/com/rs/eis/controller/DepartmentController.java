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

import com.rs.eis.model.Departments;
import com.rs.eis.repository.DepartmentRepository;
import com.rs.eis.request.AddDepartmentVO;
import com.rs.eis.response.AddDepartmentResponse;
import com.rs.eis.response.DeleteDepartmentResponse;
import com.rs.eis.response.EditDepartmentResponse;
import com.rs.eis.response.GetDepartmentResponse;
import com.rs.eis.response.GetDepartmentsResponse;
import com.rs.eis.service.DepartmentService;
import com.rs.eis.validation.ValidationDepartmentUtil;


@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentService DepartmentService;

	@Autowired
	ValidationDepartmentUtil validationDepartmentUtil;

	@Autowired
	DepartmentRepository departmentRepository;

	@PostMapping("/department")
	public AddDepartmentResponse addDepartment(@Valid @RequestBody AddDepartmentVO addDepartmentVO) {
		Set<String> errorMessages = validationDepartmentUtil.validateAddDepartmentRequest(addDepartmentVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddDepartmentResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return DepartmentService.addDepartment(addDepartmentVO);
		}
	}

	@PutMapping("/department/{id}")
	public EditDepartmentResponse editDepartment(@PathVariable("id") int id, @Valid @RequestBody Departments department) {
		return DepartmentService.editDepartment(department);
	}

	@DeleteMapping("/department/{id}")
	public DeleteDepartmentResponse deleteDepartment(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationDepartmentUtil.validateDeleteDepartmentRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteDepartmentResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return DepartmentService.deleteDepartment(id);
		}

	}

	@GetMapping("/department/{id}")
	public GetDepartmentResponse getDepartmentById(@PathVariable("id") Integer id) {
		Set<String> errorMessages = validationDepartmentUtil.validateGetDepartmentRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetDepartmentResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return DepartmentService.getDepartmentById(id);
		}
	}

	@GetMapping("/departments/{id}")
	public GetDepartmentsResponse getDepartments(@PathVariable("id") Integer id) {
		Set<String> errorMessages = validationDepartmentUtil.validateGetDepartmentsRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetDepartmentsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return DepartmentService.getDepartments(id);
		}
	}
	
	
}
