package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

<<<<<<< HEAD

import com.rs.eis.model.Perfomance_review;
import com.rs.eis.repository.Perfomance_reviewRepository;
import com.rs.eis.response.AddPerfomance_reviewResponse;
import com.rs.eis.response.DeletePerfomance_reviewResponse;
import com.rs.eis.response.EditPerfomance_reviewResponse;
import com.rs.eis.response.GetPerfomance_reviewResponse;
=======
import com.rs.eis.model.Emp_awards;
import com.rs.eis.repository.Emp_awardsRepository;
import com.rs.eis.response.AddEmp_awardsResponse;
import com.rs.eis.response.DeleteEmp_awardsResponse;
import com.rs.eis.response.EditEmp_awardsResponse;
import com.rs.eis.response.GetAllEmp_awardsResponse;
import com.rs.eis.response.GetEmp_awardsResponse;
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
import com.rs.eis.service.EISService;
<<<<<<< HEAD
import com.rs.eis.util.DateUtil;
=======
import com.rs.fer.util.DateUtil;
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

@Service
public class EISServiceImpl implements EISService {
<<<<<<< HEAD

	
=======
	private static final Emp_awards Emp_awards = null;
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
	@Autowired
<<<<<<< HEAD
	Perfomance_reviewRepository perfomance_reviewRepository;

		
	
	
		
	@Override
	public GetPerfomance_reviewResponse getPerfomance_reviewByemployeeid(int employeeid) {
		GetPerfomance_reviewResponse response = new GetPerfomance_reviewResponse();
		Optional<Perfomance_review> perfomance_reviewObj = perfomance_reviewRepository.findByemployeeid(employeeid);
		if (perfomance_reviewObj.isPresent()) {

			response.setPerfomance_review(perfomance_reviewObj.get());
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
	public AddPerfomance_reviewResponse addPerfomance_review(Perfomance_review perfomance_review) {
		AddPerfomance_reviewResponse response = new AddPerfomance_reviewResponse();

		Optional<Perfomance_review> perfomance_reviewObj = perfomance_reviewRepository
				.findById(perfomance_review.getreviewid());

				perfomance_review.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		perfomance_review = perfomance_reviewRepository.save(perfomance_review);

		response.setPerfomance_review(perfomance_review);

		response.setStatusCode("000");

		
		return response;

	}
=======
	Emp_awardsRepository emp_awardsRepository;
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

<<<<<<< HEAD
	
=======
	@Override
	public AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards) {
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

<<<<<<< HEAD
	@Override
	public DeletePerfomance_reviewResponse deletePerfomance_review(int employeeid) {
		DeletePerfomance_reviewResponse response = new DeletePerfomance_reviewResponse();
=======
		AddEmp_awardsResponse response = new AddEmp_awardsResponse();

		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(emp_awards.getawardsid());

		if (emp_awardsObj.isPresent()) {

			emp_awards.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			emp_awards = emp_awardsRepository.save(emp_awards);

			response.setEmp_awards(emp_awards);
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

		Optional<Perfomance_review> perfomance_reviewObj = perfomance_reviewRepository.findByemployeeid(employeeid);

		if (perfomance_reviewObj.isPresent()) {
			Perfomance_review perfomance_review = perfomance_reviewObj.get();
			perfomance_reviewRepository.delete(perfomance_review);
			response.setStatusCode("000");

			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
<<<<<<< HEAD
			response.setErrorMessage("Invalid Input as EmployeeId is not present in perfomance_review table");
=======
			response.setErrorMessage("Invalid Input as Emp_awards are  not present in awards table");
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
		}

		return response;
	}



	@Override
<<<<<<< HEAD
	public EditPerfomance_reviewResponse editPerfomance_review(Perfomance_review perfomance_review) {
			EditPerfomance_reviewResponse response = new EditPerfomance_reviewResponse();

			Optional<Perfomance_review> perfomance_reviewObj = perfomance_reviewRepository.findById(perfomance_review.getId());

			if (perfomance_reviewObj.isPresent()) {

				
				perfomance_review.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
				  perfomance_review = perfomance_reviewRepository.save(perfomance_review);

				response.setPerfomance_review(perfomance_review);

				response.setStatusCode("000");
				response.setStatus(HttpStatus.OK);
			} else {
				response.setStatusCode("001");
				response.setStatus(HttpStatus.PRECONDITION_FAILED);
				response.setErrorMessage("Invalid Input as Perfomance_reviewId is not present in Perfomance_review table");
			}

			return response;
=======
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
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
		}
<<<<<<< HEAD
=======

		return response;

>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
	}

<<<<<<< HEAD
=======
	@Override
	public DeleteEmp_awardsResponse deleteEmp_awards(int id) {
		DeleteEmp_awardsResponse response = new DeleteEmp_awardsResponse();
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

<<<<<<< HEAD

	
=======
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
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

<<<<<<< HEAD
=======
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
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
