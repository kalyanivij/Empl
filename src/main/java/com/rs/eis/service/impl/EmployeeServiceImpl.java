package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.eis.model.Employee;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.request.AddEmployeeVO;
import com.rs.eis.response.AddEmployeeResponse;
import com.rs.eis.response.DeleteEmployeeResponse;
import com.rs.eis.response.EditEmployeeResponse;
import com.rs.eis.response.GetEmployeeResponse;
import com.rs.eis.service.EmployeeService;
import com.rs.eis.util.DateUtil;
import com.rs.eis.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public AddEmployeeResponse addEmployee(AddEmployeeVO addEmployeeVO) {

		AddEmployeeResponse response = new AddEmployeeResponse();

		List<Employee> employees = employeeRepository.findByAadharNo(addEmployeeVO.getAadharNo());

		if (CollectionUtils.isEmpty(employees)) {

			Employee employee = EmployeeUtil.loadAddEmployeeVOToEmployee(addEmployeeVO);

			employee = employeeRepository.save(employee);

			response.setEmployee(employee);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Employee is already registered");
		}

		return response;
	}

	public EditEmployeeResponse editEmployee(Employee employee) {
		EditEmployeeResponse response = new EditEmployeeResponse();

		Optional<Employee> employeeObj = employeeRepository.findById(employee.getId());

		if (employeeObj.isPresent()) {

			employee.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			employee = employeeRepository.save(employee);

			response.setEmployee(employee);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in employee table");
		}

		return response;
	}

	@Override
	public GetEmployeeResponse getEmployeeById(int id) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		Optional<Employee> employeeObj = employeeRepository.findById(id);
		if (employeeObj.isPresent()) {
			response.setEmployee(employeeObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Employee Found for the given employeeid");
		}

		return response;
	}

	@Override
	public DeleteEmployeeResponse deleteEmployee(int id) {
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();

		Optional<Employee> employeeObj = employeeRepository.findById(id);

		if (employeeObj.isPresent()) {
			Employee employee = employeeObj.get();
			employeeRepository.delete(employee);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in employee table");
		}

		return response;

	}

}
