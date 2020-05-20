package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.eis.model.Employer;
import com.rs.eis.repository.EmployerRepository;
import com.rs.eis.request.AddEmployerVO;
import com.rs.eis.response.AddEmployerResponse;
import com.rs.eis.response.EditEmployerResponse;
import com.rs.eis.response.GetEmployeesResponse;
import com.rs.eis.service.EmployerService;
import com.rs.eis.util.DateUtil;
import com.rs.eis.util.EmployerUtil;

@Service
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	EmployerRepository employerRepository;

	public AddEmployerResponse addEmployer(AddEmployerVO addEmployerVO) {

		AddEmployerResponse response = new AddEmployerResponse();

		List<Employer> employers = employerRepository.findByBranch(addEmployerVO.getBranch());

		if (CollectionUtils.isEmpty(employers)) {

			Employer employer = EmployerUtil.loadAddEmployerVOToEmployer(addEmployerVO);

			employer = employerRepository.save(employer);

			response.setEmployer(employer);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Employer is already registered");
		}

		return response;
	}

	public EditEmployerResponse editEmployer(Employer employer) {
		EditEmployerResponse response = new EditEmployerResponse();

		Optional<Employer> employerObj = employerRepository.findById(employer.getId());

		if (employerObj.isPresent()) {

			employer.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			employer = employerRepository.save(employer);

			response.setEmployer(employer);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employerId is not present in employer table");
		}

		return response;
	}

	@Override
	public GetEmployeesResponse getEmployees(int id) {
		GetEmployeesResponse response = new GetEmployeesResponse();
		Optional<Employer> employees = employerRepository.findById(id);
		if (employees.isPresent()) {
			// response.setEmployer(employees);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employerId is not present in employer table");
		}

		return response;
	}

}
