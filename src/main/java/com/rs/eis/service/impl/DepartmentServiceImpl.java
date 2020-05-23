package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.eis.model.Departments;
import com.rs.eis.repository.DepartmentRepository;
import com.rs.eis.request.AddDepartmentVO;
import com.rs.eis.response.AddDepartmentResponse;
import com.rs.eis.response.DeleteDepartmentResponse;
import com.rs.eis.response.EditDepartmentResponse;
import com.rs.eis.response.GetDepartmentResponse;
import com.rs.eis.response.GetDepartmentsResponse;
import com.rs.eis.service.DepartmentService;
import com.rs.eis.util.DateUtil;
import com.rs.eis.util.DepartmentUtil;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public AddDepartmentResponse addDepartment(@Valid AddDepartmentVO addDepartmentVO) {

		AddDepartmentResponse response = new AddDepartmentResponse();

		List<Departments> department = departmentRepository.findAllById(addDepartmentVO.getId());

		if (CollectionUtils.isEmpty(department)) {

			Departments departments = DepartmentUtil.loadAddDepartmentVOToDepartment(addDepartmentVO);

			departments.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			departments.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			departments = departmentRepository.save(departments);

			response.setDepartment(departments);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in department table");
		}

		return response;
	}

	@Override
	public EditDepartmentResponse editDepartment(@Valid Departments department) {
		EditDepartmentResponse response = new EditDepartmentResponse();

		Optional<Departments> departmentObj = departmentRepository.findById(department.getId());

		if (departmentObj.isPresent()) {

			department.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			 department.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			department = departmentRepository.save(department);

			response.setDepartment(department);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in department table");
		}

		return response;
	}

	@Override
	public DeleteDepartmentResponse deleteDepartment(int id) {
		DeleteDepartmentResponse response = new DeleteDepartmentResponse();

		Optional<Departments> departmentObj = departmentRepository.findById(id);

		if (departmentObj.isPresent()) {
			Departments department = departmentObj.get();
			departmentRepository.delete(department);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in department table");
		}

		return response;
	}

	@Override
	public GetDepartmentResponse getDepartmentById(Integer id) {
		GetDepartmentResponse response = new GetDepartmentResponse();
		Optional<Departments> departmentObj = departmentRepository.findById(id);
		if (departmentObj.isPresent()) {
			response.setDepartment(departmentObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No department Found for the given id");
		}

		return response;
	}

	@Override
	public GetDepartmentsResponse getDepartments(Integer id) {
		GetDepartmentsResponse response = new GetDepartmentsResponse();
		List<Departments> departments = departmentRepository.findAllById(id);
		if (!departments.isEmpty()) {
			response.setDepartment(departments);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
		}

		return response;
	}

}
