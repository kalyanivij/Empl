package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Perfomance_review;

public class GetPerfomance_reviewResponse extends AbstractResponse {

	public GetPerfomance_reviewResponse() {

	}

	public GetPerfomance_reviewResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Perfomance_review perfomance_review;

	public Perfomance_review getPerfomance_review() {

		return perfomance_review;

	}

	public void setPerfomance_review(Perfomance_review perfomance_review) {

		this.perfomance_review = perfomance_review;
	}

}
