package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Trainings;
import com.rs.fer.response.AbstractResponse;

public class GetTrainingsResponse extends AbstractResponse {

	public GetTrainingsResponse() {

	}

	public GetTrainingsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public List<Trainings> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Trainings> trainings) {
		this.trainings = trainings;
	}

	private List<Trainings> trainings;

	

}
