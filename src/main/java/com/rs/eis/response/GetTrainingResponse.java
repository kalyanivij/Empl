package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Trainings;

public class GetTrainingResponse extends AbstractResponse {
	
	public GetTrainingResponse() {

	}

	public GetTrainingResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}
	
	private Trainings trainings;
	
	public Trainings getTrainings() {
		return trainings;
	}

	public void setTrainings(Trainings trainings) {
		this.trainings = trainings;
	}

		
}
