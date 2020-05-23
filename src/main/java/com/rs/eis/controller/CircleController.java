package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Circle;
import com.rs.eis.repository.CircleRepository;
import com.rs.eis.request.AddCircleVO;
import com.rs.eis.response.AddCircleResponse;
import com.rs.eis.response.DeleteCircleResponse;
import com.rs.eis.response.EditCircleResponse;
import com.rs.eis.response.GetCircleResponse;
import com.rs.eis.response.GetCirclesResponse;
import com.rs.eis.response.GetDepartmentsResponse;
import com.rs.eis.service.CircleService;
import com.rs.eis.validation.ValidationCircleUtil;

@RestController
@RequestMapping("/api")
public class CircleController {

	@Autowired
	CircleService CircleService;

	@Autowired
	ValidationCircleUtil validationCircleUtil;

	@Autowired
	CircleRepository circleRepository;

	@PostMapping("/circle")
	public AddCircleResponse addCircle(@Valid @RequestBody AddCircleVO addCircleVO) {
		Set<String> errorMessages = validationCircleUtil.validateAddCircleRequest(addCircleVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddCircleResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return CircleService.addCircle(addCircleVO);
		}
	}

	@PutMapping("/circle/{id}")
	public EditCircleResponse editCircle(@PathVariable("id") int Id, @Valid @RequestBody Circle circle) {
		return CircleService.editCircle(circle);
	}

	@GetMapping("/circle/{id}")
	public GetCircleResponse getCircle(@PathVariable("id") int id) {
		Set<String> errorMessages = validationCircleUtil.validateGetCircleRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetCircleResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return CircleService.getCircle(id);
		}
	}

	@DeleteMapping("/circle/{id}")
	public DeleteCircleResponse deleteCircle(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationCircleUtil.validateDeleteCircleRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteCircleResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return CircleService.deleteCircle(id);
		}

	}
	
	@GetMapping("/circles/{id}")
	public GetCirclesResponse getCircles(@PathVariable("id") Integer id) {
		Set<String> errorMessages = validationCircleUtil.validateGetCirclesRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetCirclesResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return CircleService.getCircles(id);
		}
	}
	
}
