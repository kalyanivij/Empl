package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Trainings;

public class GetTrainingsResponse extends AbstractResponse {
	private List<Trainings> trainings;

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



	

}
