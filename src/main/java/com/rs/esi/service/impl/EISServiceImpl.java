package com.rs.esi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.esi.model.Emp_awards;
import com.rs.esi.repository.Emp_awardsRepository;
import com.rs.esi.model.Expense;
import com.rs.esi.model.User;

import com.rs.esi.request.RegistrationVO;
import com.rs.esi.request.UserVO;
import com.rs.esi.response.AddEmp_awardsResponse;

import com.rs.esi.response.DeleteEmp_awardsResponse;
import com.rs.esi.response.EditEmp_awardsResponse;
import com.rs.esi.response.Emp_awardsReportResponse;
import com.rs.esi.response.GetEmp_awardsResponse;
import com.rs.esi.service.EISService;
import com.rs.fer.util.DateUtil;
import com.rs.fer.util.FERUtil;

@Service
public class EISServiceImpl implements EISService {
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

	/*
	 * @Override public Emp_awardsReportResponse emp_awardsReport(int awardsid,
	 * String Date, String created, String updated) { Emp_awardsReportResponse
	 * response = new Emp_awardsReportResponse(); Expense exp = new Expense();
	 * 
	 * List<Emp_awards> emp_awards = emp_awardsRepository.findByemployeeid(Date,
	 * created, updated); if (!emp_awards.isEmpty()) {
	 * 
	 * response.setEmp_awards(emp_awards); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK);
	 * 
	 * } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("No emp_awards found for the given input.."); }
	 * 
	 * return response; }
	 */

	@Override
	public DeleteEmp_awardsResponse deleteEmp_awards(int employeeid) {
		DeleteEmp_awardsResponse response = new DeleteEmp_awardsResponse();

		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(employeeid);

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

}
