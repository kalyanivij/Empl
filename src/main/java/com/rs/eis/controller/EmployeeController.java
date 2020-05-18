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

import com.rs.eis.model.Employee;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.request.AddEmployeeVO;
import com.rs.eis.response.AddEmployeeResponse;
import com.rs.eis.response.DeleteEmployeeResponse;
import com.rs.eis.response.EditEmployeeResponse;
import com.rs.eis.response.GetEmployeeResponse;
import com.rs.eis.service.EmployeeService;
import com.rs.eis.validation.ValidationEmployeeUtil;

@RestController
@RequestMapping("/eis")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Autowired
	ValidationEmployeeUtil validationEmployeeUtil;

	@Autowired
	EmployeeRepository employeeRepository;

	private int expenseId;

	@PostMapping("/addEmployee")
	public AddEmployeeResponse addEmployee(@Valid @RequestBody AddEmployeeVO addEmployeeVO) {

		Set<String> errorMessages = validationEmployeeUtil.validateAddEmployeeRequest(addEmployeeVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return employeeService.addEmployee(addEmployeeVO);
		}
	}

	@PutMapping("/employee/{id}")
	public EditEmployeeResponse editEmployee(@PathVariable("id") int id, @Valid @RequestBody Employee employee) {
		Set<String> errorMessages = validationEmployeeUtil.validateEditEmployeeRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new EditEmployeeResponse();
		} else {
		return employeeService.editEmployee(employee);
	}
	}
	

	@DeleteMapping("/employee/{id}")
	public DeleteEmployeeResponse deleteEmployee(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationEmployeeUtil.validateDeleteEmployeeRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return employeeService.deleteEmployee(id);
		}
	}

	/*
	 * @PutMapping("/user") public UpdateUserResponse update(@RequestBody UserVO
	 * userVO) { Set<String> errorMessages =
	 * validationUtil.validateUpdateUserRequest(userVO); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages); }
	 * else { return ferService.updateUser(userVO); } }
	 */
}
