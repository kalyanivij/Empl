package com.rs.eis.service;

import com.rs.eis.model.Trainings;
import com.rs.eis.request.TrainingsVO;
import com.rs.eis.response.AddEmployeeTrainingsResponse;
import com.rs.eis.response.AddEmployerTrainingsResponse;
import com.rs.eis.response.DeleteTrainingsResponse;
import com.rs.eis.response.EditTrainingsResponse;
import com.rs.eis.response.GetTrainingResponse;
import com.rs.eis.response.GetTrainingsResponse;

public interface TrainingService {
	
	AddEmployeeTrainingsResponse saveTrainingEmployee(TrainingsVO trainingsVO);
	
	AddEmployerTrainingsResponse saveTrainingEmployer(TrainingsVO trainingsVO);
	
	EditTrainingsResponse editTraining(Trainings trainings);
	
	DeleteTrainingsResponse deleteTraining(int trainingId);
	
	GetTrainingResponse getTrainingsById(int trainingId);
	
	GetTrainingsResponse getTrainings(int employeeId);
	
	GetTrainingsResponse getTraining(int employerId);
	
}
