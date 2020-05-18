package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Trainings;
import com.rs.fer.response.AbstractResponse;

public class DeleteTrainingsResponse extends AbstractResponse {

private Trainings trainings;
	
	public DeleteTrainingsResponse() {

	}

	public DeleteTrainingsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Trainings getTrainings() {
		return trainings;
	}

	public void setTrainings(Trainings trainings) {
		this.trainings = trainings;
	}

}
