
package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Perfomance_review;

public class Perfomance_reviewReportResponse extends AbstractResponse {

	private List<Perfomance_review> perfomance_review;

	public Perfomance_reviewReportResponse() {

	}

	public Perfomance_reviewReportResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);

		super.setStatusCode(statusCode);

		super.setErrorMessages(errorMessages);

	}

	public List<Perfomance_review> getPerfomance_review() {
		return perfomance_review;

	}

	public void setPerfomance_review(List<Perfomance_review> perfomance_review) {
		this.perfomance_review = perfomance_review;
	}

}
