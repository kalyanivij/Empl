package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Emp_awards;
import com.rs.eis.repository.Emp_awardsRepository;
import com.rs.eis.response.AddEmp_awardsResponse;
import com.rs.eis.response.DeleteEmp_awardsResponse;
import com.rs.eis.response.EditEmp_awardsResponse;
import com.rs.eis.response.GetAllEmp_awardsResponse;
import com.rs.eis.response.GetEmp_awardsResponse;
import com.rs.eis.service.EISService;
import com.rs.fer.util.DateUtil;

@Service
public class EISServiceImpl implements EISService {
	private static final Emp_awards Emp_awards = null;
	@Autowired
	Emp_awardsRepository emp_awardsRepository;

	@Override
	public AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards) {

		AddEmp_awardsResponse response = new AddEmp_awardsResponse();

		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(emp_awards.getawardsid());

		if (emp_awardsObj.isPresent()) {

			emp_awards.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			emp_awards = emp_awardsRepository.save(emp_awards);

			response.setEmp_awards(emp_awards);

			response.setStatusCode("000");

			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Emp_awards are  not present in awards table");
		}

		return response;
	}

	@Override
	public GetEmp_awardsResponse getEmp_awardsByemployeeid(int awardsid) {
		GetEmp_awardsResponse response = new GetEmp_awardsResponse();
		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(awardsid);
		if (emp_awardsObj.isPresent()) {

			response.setEmp_awards(emp_awardsObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Employee award Found for the given employeeid");
		}

		return response;

	}

	@Override
	public DeleteEmp_awardsResponse deleteEmp_awards(int id) {
		DeleteEmp_awardsResponse response = new DeleteEmp_awardsResponse();

		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findByid(id);

		if (emp_awardsObj.isPresent()) {
			Emp_awards emp_awards = emp_awardsObj.get();
			emp_awardsRepository.delete(emp_awards);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as EmployeeId is not present in Emp_awards table");
		}

		return response;

	}

	@Override
	public EditEmp_awardsResponse editEmp_awards(Emp_awards emp_awards) {
		EditEmp_awardsResponse response = new EditEmp_awardsResponse();

		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(emp_awards.getId());

		if (emp_awardsObj.isPresent()) {

			/*
			 * emp_awards.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			 */ emp_awards = emp_awardsRepository.save(emp_awards);

			response.setEmp_awards(emp_awards);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as emp_awardsId is not present in awards table");
		}

		return response;
	}

	@Override
	public GetAllEmp_awardsResponse allEmp_awards(int employeeid) {
		GetAllEmp_awardsResponse response = new GetAllEmp_awardsResponse();
		List<Emp_awards> emp_awardsobj = emp_awardsRepository.findByemployeeid(employeeid);
		if (!emp_awardsobj.isEmpty()) {
			response.setEmp_awards(emp_awardsobj);
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
