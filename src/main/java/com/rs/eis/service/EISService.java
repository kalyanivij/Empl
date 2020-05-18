package com.rs.eis.service;

import com.rs.eis.model.Trainings;
import com.rs.eis.response.DeleteTrainingsResponse;
import com.rs.eis.response.EditTrainingsResponse;
import com.rs.eis.response.GetTrainingResponse;
import com.rs.eis.response.GetTrainingsResponse;
import com.rs.eis.response.TrainingsResponse;

public interface EISService {
	
	TrainingsResponse saveTraining(Trainings trainings);
	
	EditTrainingsResponse editTraining(Trainings trainings);
	
	DeleteTrainingsResponse deleteTraining(int trainingId);
	
	GetTrainingResponse getTrainingsById(int trainingId);
	
	GetTrainingsResponse getTrainings(int employeeid);
	
	GetTrainingsResponse getTrainingsByEmployerId(int employerid);
	
}
