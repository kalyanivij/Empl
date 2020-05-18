package com.rs.eis.service;

import com.rs.eis.model.Employer;
import com.rs.eis.request.AddEmployerVO;
import com.rs.eis.response.AddEmployerResponse;
import com.rs.eis.response.EditEmployerResponse;
import com.rs.eis.response.GetEmployeesResponse;

public interface EmployerService {
	
	AddEmployerResponse addEmployer(AddEmployerVO addEmployerVO);

	EditEmployerResponse editEmployer(Employer employer);

	GetEmployeesResponse getEmployees(int id);

}
