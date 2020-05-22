package com.rs.eis.validation;

import java.util.Set;

public interface TrainingValidationUtil {
	
	Set<String> validateDeleteTrainingsRequest(int trainingId);

	Set<String> validateGetTrainingRequest(int trainingId);

	Set<String> validateGetTrainingsRequest(int employerid);

}
