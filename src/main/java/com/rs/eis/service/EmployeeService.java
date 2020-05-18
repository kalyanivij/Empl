package com.rs.eis.service;

import com.rs.eis.request.AddEmployeeVO;

import com.rs.eis.response.AddEmployeeResponse;
import com.rs.eis.response.DeleteEmployeeResponse;
import com.rs.eis.response.EditEmployeeResponse;
import com.rs.eis.response.GetEmployeeResponse;
import com.rs.eis.model.Employee;

public interface EmployeeService {
	AddEmployeeResponse addEmployee(AddEmployeeVO addEmployeeVO);

	EditEmployeeResponse editEmployee(EmployeeService employee);

	GetEmployeeResponse getEmployeeById(int id);

	DeleteEmployeeResponse deleteEmployee(int id);

	//UpdateEmployeeResponse updateEmployee(EmployeeVO employeeVO);
}
