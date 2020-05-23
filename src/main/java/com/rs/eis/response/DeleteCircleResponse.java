package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Circle;

public class DeleteCircleResponse extends AbstractResponse {
	
	private Circle circle;

	public DeleteCircleResponse() {
		
	}
	
	public DeleteCircleResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
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

	
	
	
	
}
