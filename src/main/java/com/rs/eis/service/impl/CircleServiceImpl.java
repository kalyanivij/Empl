package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.eis.model.Circle;
import com.rs.eis.model.Departments;
import com.rs.eis.repository.CircleRepository;
import com.rs.eis.request.AddCircleVO;
import com.rs.eis.response.AddCircleResponse;
import com.rs.eis.response.DeleteCircleResponse;
import com.rs.eis.response.DeleteDepartmentResponse;
import com.rs.eis.response.EditCircleResponse;
import com.rs.eis.response.GetCircleResponse;
import com.rs.eis.response.GetCirclesResponse;
import com.rs.eis.response.GetDepartmentsResponse;
import com.rs.eis.service.CircleService;
import com.rs.eis.util.CircleUtil;
import com.rs.eis.util.DateUtil;

@Service
public class CircleServiceImpl implements CircleService {

	

	@Autowired
	CircleRepository circleRepository;


	@Override
	public AddCircleResponse addCircle(@Valid AddCircleVO addCircleVO) {
   AddCircleResponse response = new AddCircleResponse();
		
		List<Circle> circle = circleRepository.findByName(addCircleVO.getName());
	
				if (CollectionUtils.isEmpty(circle)) {

					Circle circles = CircleUtil.loadAddCircleVOToCircle(addCircleVO);


			circles.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			circles.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			circles = circleRepository.save(circles);

			response.setCircle(circles);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in circle table");
		}
		
		
		return response;
	}


	@Override
	public EditCircleResponse editCircle(@Valid Circle circle) {
		EditCircleResponse response = new EditCircleResponse();

		Optional<Circle> employerObj = 
				circleRepository.findById(circle.getId());

		if (employerObj.isPresent()) {

			circle.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			circle.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			circle = circleRepository.save(circle);

			response.setCircle(circle);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in circle table");
		}

		return response;
	}


	@Override
	public GetCircleResponse getCircle(int id) {
		GetCircleResponse response = new GetCircleResponse();
		Optional<Circle> circle = circleRepository.findById(id);
		if (circle.isPresent()) {
			response.setCircle(circle.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in circle table");
		}

		return response;
	
	}


	@Override
	public DeleteCircleResponse deleteCircle(int id) {
		DeleteCircleResponse response = new DeleteCircleResponse();

		Optional<Circle> circleObj = circleRepository.findById(id);

		if (circleObj.isPresent()) {
			Circle circle = circleObj.get();
			circleRepository.delete(circle);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in circle table");
		}

		return response;
	}


	@Override
	public GetCirclesResponse getCircles(Integer id) {
		GetCirclesResponse response = new GetCirclesResponse();
		List<Circle> circles = circleRepository.findAllById(id);
		if (!circles.isEmpty()) {
			response.setCircle(circles);
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
