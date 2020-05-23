package com.rs.eis.service;

import javax.validation.Valid;

import com.rs.eis.model.Circle;
import com.rs.eis.request.AddCircleVO;
import com.rs.eis.request.AddDepartmentVO;
import com.rs.eis.response.AddCircleResponse;
import com.rs.eis.response.AddDepartmentResponse;
import com.rs.eis.response.DeleteCircleResponse;
import com.rs.eis.response.DeleteDepartmentResponse;
import com.rs.eis.response.EditCircleResponse;
import com.rs.eis.response.GetCircleResponse;
import com.rs.eis.response.GetCirclesResponse;

public interface CircleService {

	

	AddCircleResponse addCircle(@Valid AddCircleVO addCircleVO);

	EditCircleResponse editCircle(@Valid Circle circle);

	GetCircleResponse getCircle(int id);

	DeleteCircleResponse deleteCircle(int id);

	GetCirclesResponse getCircles(Integer id);
	

	

	

}
