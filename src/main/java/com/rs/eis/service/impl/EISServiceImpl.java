package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.rs.eis.model.Perfomance_review;
import com.rs.eis.repository.Perfomance_reviewRepository;
import com.rs.eis.response.AddPerfomance_reviewResponse;
import com.rs.eis.response.DeletePerfomance_reviewResponse;
import com.rs.eis.response.EditPerfomance_reviewResponse;
import com.rs.eis.response.GetPerfomance_reviewResponse;
import com.rs.eis.service.EISService;
import com.rs.eis.util.DateUtil;

@Service
public class EISServiceImpl implements EISService {

	
	@Autowired
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

	

	@Override
	public DeletePerfomance_reviewResponse deletePerfomance_review(int employeeid) {
		DeletePerfomance_reviewResponse response = new DeletePerfomance_reviewResponse();

		Optional<Perfomance_review> perfomance_reviewObj = perfomance_reviewRepository.findByemployeeid(employeeid);

		if (perfomance_reviewObj.isPresent()) {
			Perfomance_review perfomance_review = perfomance_reviewObj.get();
			perfomance_reviewRepository.delete(perfomance_review);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as EmployeeId is not present in perfomance_review table");
		}

		return response;
	}



	@Override
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
		}
	}



	

