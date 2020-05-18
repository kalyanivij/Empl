package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.QualificationVO;
import com.rs.eis.validation.ValidationUtil;

@Component
public class ValidationUtilImpl implements ValidationUtil {

	public Set<String> validateQualificationRequest(QualificationVO qualificationVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, qualificationVO.getEducation(), "Please enter education");
		addError(errorMessages, qualificationVO.getCourse(), "Please enter course");

		addError(errorMessages, qualificationVO.getSpecialization(), "Please enter specialization");
		addError(errorMessages, qualificationVO.getUniversity(), "lease enter university");

		addError(errorMessages, qualificationVO.getCourse_type(), "Please enter course_type");
		addError(errorMessages, qualificationVO.getGrade(), "Please enter grade");
		addError(errorMessages, qualificationVO.getMarks(), "Please enter marks");
		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetQualificatuonRequest(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid qualification id");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteQualificationRequest(int id) {
		return validateGetQualificatuonRequest(id);
	}

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

}
