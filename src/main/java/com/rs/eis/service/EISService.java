package com.rs.eis.service;


import com.rs.eis.model.Trainings;
import com.rs.eis.response.AddEmployeeTrainingsResponse;
import com.rs.eis.response.AddEmployerTrainingsResponse;
import com.rs.eis.response.DeleteTrainingsResponse;
import com.rs.eis.response.EditTrainingsResponse;
import com.rs.eis.response.GetTrainingResponse;
import com.rs.eis.response.GetTrainingsResponse;
import com.rs.eis.response.TrainingsResponse;

public interface EISService {
	AddEmployeeTrainingsResponse saveTrainingEmployee(Trainings trainings);
	
	AddEmployerTrainingsResponse saveTrainingEmployer(Trainings trainings);
	
	EditTrainingsResponse editTraining(Trainings trainings);

	DeleteTrainingsResponse deleteTraining(int trainingId);

	GetTrainingResponse getTrainingsById(int trainingId);
	
	GetTrainingsResponse getTrainings(int employeeId);
	
	GetTrainingsResponse getTraining(int employerId);

	
	
}
