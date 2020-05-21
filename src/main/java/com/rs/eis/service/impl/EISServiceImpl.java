package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
import com.rs.eis.response.EditSalaryResponse;
import com.rs.eis.response.Emp_DesignationResponse;
import com.rs.eis.response.GetDesignationResponse;
import com.rs.eis.response.GetEmp_DesignationResponse;
import com.rs.eis.response.GetSalaryResponse;
import com.rs.eis.response.SalaryResponse;
import com.rs.eis.service.EISService;

@Service
public class EISServiceImpl implements EISService {

	@Autowired
	DesignationRepository designationRepository;
	@Autowired
	Emp_DesignationRepository emp_designationRepository;
	@Autowired
	SalaryRepository salaryRepository;

	public DesignationResponse addDesignation(Designation designation) {
		DesignationResponse response = new DesignationResponse();

		/*
		 * Optional<Designation> userObj =
		 * designationRepository.findById(designation.getUserId());
		 * 
		 * if (userObj.isPresent()) {
		 */
		designation = designationRepository.save(designation);

		response.setDesignation(designation);

		response.setStatusCode("000");
		response.setStatus(
				HttpStatus.OK); /*
								 * else { response.setStatusCode("001"); response.setStatus(HttpStatus.
								 * PRECONDITION_FAILED); response.
								 * setErrorMessage("Invalid Input as userId is not present in user table" ); }
								 */
		return response;

	}

	public Emp_DesignationResponse addemp_designation(Emp_Designation emp_designation) {
		Emp_DesignationResponse response = new Emp_DesignationResponse();

		/*
		 * Optional<Emp_Designation> userObj =
		 * emp_designationRepository.findById(emp_designation.getEmployeeid());
		 * 
		 * if (userObj.isPresent()) {
		 */

		// emp_designation.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		emp_designation = emp_designationRepository.save(emp_designation);

		response.setEmp_designation(emp_designation);

		response.setStatusCode("000");
		response.setStatus(HttpStatus.OK);
		/*
		 * } else { response.setStatusCode("001");
		 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
		 * setErrorMessage("Invalid Input as userId is not present in user table"); }
		 */
		return response;
	}

	@Override
	public GetEmp_DesignationResponse getemp_DesignationById(int id) {
		GetEmp_DesignationResponse response = new GetEmp_DesignationResponse();
		Optional<Emp_Designation> dObj = emp_designationRepository.findById(id);
		if (dObj.isPresent()) {
			response.setEmp_designation(dObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public SalaryResponse addSalary(Salary salary) {
		SalaryResponse response = new SalaryResponse();

		/*
		 * Optional<Salary> userObj = salaryRepository.findById(salary.getEmployeeid());
		 * 
		 * if (userObj.isPresent()) {
		 */
		// salary.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		salary = salaryRepository.save(salary);

		response.setSalary(salary);

		response.setStatusCode("000");
		response.setStatus(HttpStatus.OK);
		/*
		 * } else { response.setStatusCode("001");
		 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
		 * setErrorMessage("Invalid Input as userId is not present in user table"); }
		 */
		return response;
	}

	@Override
	public GetDesignationResponse getDesignationById(int id) {
		GetDesignationResponse response = new GetDesignationResponse();
		Optional<Designation> dObj = designationRepository.findById(id);
		if (dObj.isPresent()) {
			response.setDesignation(dObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public DeleteDesignationResponse deleteDesignation(Integer id) {
		DeleteDesignationResponse response = new DeleteDesignationResponse();
		Optional<Designation> dObj = designationRepository.findById(id);
		if (dObj.isPresent()) {
			Designation Designation = dObj.get();
			designationRepository.delete(Designation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	public EditDesignationResponse editDesignation(Designation designation) {
		EditDesignationResponse response = new EditDesignationResponse();
		Optional<Designation> dObj = designationRepository.findById(designation.getId());
		if (dObj.isPresent()) {
			designation = designationRepository.save(designation);
			response.setDesignation(designation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}

		return response;
	}

	public EditSalaryResponse editSlary(Salary salary) {
		EditSalaryResponse response = new EditSalaryResponse();
		Optional<Salary> dObj = salaryRepository.findById(salary.getId());
		if (dObj.isPresent()) {
			salary = salaryRepository.save(salary);
			response.setSalary(salary);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}

		return response;
	}

	@Override
	public GetSalaryResponse getSalaryById(int id) {
		GetSalaryResponse response = new GetSalaryResponse();
		Optional<Salary> dObj = salaryRepository.findById(id);
		if (dObj.isPresent()) {
			response.setSalary(dObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public EditSalaryResponse edit(Salary salary) {
		// TODO Auto-generated method stub
		return null;
	}

	public DeleteDesignationResponse emp_deleteDesignation(Integer id) {
		DeleteDesignationResponse response = new DeleteDesignationResponse();
		Optional<Designation> dObj = designationRepository.findById(id);
		if (dObj.isPresent()) {
			Designation Designation = dObj.get();
			designationRepository.delete(Designation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public DeleteEmp_DesignationResponse deleteemp_Designation(int id) {
		DeleteEmp_DesignationResponse response = new DeleteEmp_DesignationResponse();
		Optional<Emp_Designation> dObj = emp_designationRepository.findById(id);
		if (dObj.isPresent()) { 
			Emp_Designation Emp_Designation = dObj.get();
			emp_designationRepository.delete(Emp_Designation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;

	}

	@Override
	public EditEmp_DesignationResponse editemp_Designation(Emp_Designation emp_designation) {
		EditEmp_DesignationResponse response = new EditEmp_DesignationResponse();
		Optional<Emp_Designation> dObj = emp_designationRepository.findById(emp_designation.getId());
		if (dObj.isPresent()) {
			emp_designation = emp_designationRepository.save(emp_designation);
			response.setEmp_designation(emp_designation); 
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}

		return response;    

	}

	@Override
	public DeleteSalaryResponse deletesalary(Integer id) {
		DeleteSalaryResponse response = new DeleteSalaryResponse();
		Optional<Salary> dObj = salaryRepository.findById(id);
		if (dObj.isPresent()) {
			Salary Salary = dObj.get();
			salaryRepository.delete(Salary);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

}