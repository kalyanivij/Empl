package com.rs.eis.response;

import com.rs.eis.model.Trainings;

public class EditTrainingsResponse extends AbstractResponse {
	private Trainings trainings;

	public Trainings getTrainings() {
		return trainings;
	}

	public void setTrainings(Trainings trainings) {
		this.trainings = trainings;
	}
	
	

}