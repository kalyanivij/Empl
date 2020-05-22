package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.AddBookVO;
import com.rs.eis.validation.BookValidationUtil;

@Component
public class BookValidationUtilImpl implements BookValidationUtil {

	@Override
	public Set<String> validateAddBookRequest(AddBookVO addbookVO) {
		
		Set<String> errorMessages = new HashSet<String>();

		//addError(errorMessages, addbookVO.getName(), "Please enter name");
		//addError(errorMessages, addbookVO.getRefBookNumber(), "Please enter bookRefNumber");
		
		return errorMessages;
	}


	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}


	@Override
	public Set<String> validateGetBookRequest(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<String> validateEditBookRequest(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<String> validateDeleteBookRequest(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
