package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.TrainingValidationUtil;

@Component
public class TrainingValidationUtilImpl implements TrainingValidationUtil {
	

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteTrainingsRequest(int trainingId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, trainingId, "Please enter valid trainingId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetTrainingRequest(int trainingId) {
		return validateDeleteTrainingsRequest(trainingId);
	}

	@Override
	public Set<String> validateGetTrainingsRequest(int employerid) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, employerid, "Please enter valid employerid");

		return errorMessages;
	}


	}


