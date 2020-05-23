package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.AddCircleVO;
import com.rs.eis.validation.ValidationCircleUtil;

@Component
public class ValidationCircleUtilImpl implements ValidationCircleUtil {

	@Override
	public Set<String> validateAddCircleRequest(AddCircleVO addCircleVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, addCircleVO.getName(), "Please enter Name");
		addError(errorMessages, addCircleVO.getOther(), "Please enter other");
		addError(errorMessages, addCircleVO.getEmployerid(), "Please enter Employerid");
		

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetCircleRequest(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid circleId");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteCircleRequest(int id) {
		
		return validateGetCircleRequest(id);
	}

	@Override
	public Set<String> validateGetCirclesRequest(Integer id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid id");

		return errorMessages;
	}

	
	
	
}
