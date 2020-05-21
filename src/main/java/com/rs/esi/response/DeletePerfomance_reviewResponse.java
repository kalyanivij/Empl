package com.rs.esi.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.esi.model.Expense;
import com.rs.esi.model.Perfomance_Review;

public class DeletePerfomance_reviewResponse extends AbstractResponse {
private Perfomance_Review perfomance_review;
	
	public Perfomance_Review getPerfomance_review() {
		return perfomance_review;
	}
	public void setPerfomance_review(Perfomance_Review perfomance_review) {
		this.perfomance_review = perfomance_review;
	}
	public DeletePerfomance_reviewResponse() {

	}

	public DeletePerfomance_reviewResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
