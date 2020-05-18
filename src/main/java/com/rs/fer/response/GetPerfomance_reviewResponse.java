package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Perfomance_Review;

public class GetPerfomance_reviewResponse extends AbstractResponse {
	
	public GetPerfomance_reviewResponse() {
		
	}
	
	public GetPerfomance_reviewResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}
	
	//perfomance_review
	
	private Perfomance_Review perfomance_review;

	public Perfomance_Review getPerfomance_review() {
		return perfomance_review;
	}

	public void setPerfomance_review(Perfomance_Review perfomance_review) {
		this.perfomance_review = perfomance_review;
	}
	
	
	

}
