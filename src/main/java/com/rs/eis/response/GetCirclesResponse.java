package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Circle;

public class GetCirclesResponse extends AbstractResponse {
	
	private Circle circle;

	public GetCirclesResponse() {
		
	}
	
	public GetCirclesResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}
	
	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public void setCircle1(Circle circles) {
		this.circle = circles;
		
	}

	public List<Circle> setCircle(List<Circle> circles) {
		return circles;
		
	}

	
	
	
	
}
