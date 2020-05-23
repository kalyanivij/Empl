package com.rs.eis.service;

import javax.validation.Valid;

import com.rs.eis.model.Departments;
import com.rs.eis.request.AddDepartmentVO;
import com.rs.eis.response.AddDepartmentResponse;
import com.rs.eis.response.DeleteDepartmentResponse;
import com.rs.eis.response.EditDepartmentResponse;
import com.rs.eis.response.GetDepartmentResponse;
import com.rs.eis.response.GetDepartmentsResponse;

public interface DepartmentService {

	AddDepartmentResponse addDepartment(@Valid AddDepartmentVO addDepartmentVO);

	EditDepartmentResponse editDepartment(@Valid Departments department);
	

	DeleteDepartmentResponse deleteDepartment(int id);

	GetDepartmentResponse getDepartmentById(Integer id);

	GetDepartmentsResponse getDepartments(Integer id);

	
	

	

	

}
