
package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.AddLibraryVO;
import com.rs.eis.validation.LibraryValidationUtil;

@Component
public class LibraryValidationUtilImpl implements LibraryValidationUtil {

	@Override
	public Set<String> validateAddLibraryRequest(AddLibraryVO addlibraryVO) {

		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, addlibraryVO.getDate(), "Please enter date");
		addError(errorMessages, addlibraryVO.getEmployeeid(), "Please enter employeeid");
		addError(errorMessages, addlibraryVO.getBookid(), "Please enter bookid");

		addError(errorMessages, addlibraryVO.getDateReturn(), "Please enter dateReturn");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	/*
	 * public static Set<String> addError(Set<String> errorMessages, int value,
	 * String errorMessage) {
	 * 
	 * if (value <= 0) { errorMessages.add(errorMessage); }
	 * 
	 * return errorMessages; }
	 */
	@Override
	public Set<String> validateGetLibraryRequest(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid employeeId");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	/*
	 * @Override public Set<String> validateExpenseReportRequest(int userId, String
	 * type, String fromDate, String toDate) { Set<String> errorMessages = new
	 * HashSet<String>();
	 * 
	 * addError(errorMessages, userId, "Please enter userid");
	 * addError(errorMessages, type, "Please enter type");
	 * 
	 * addError(errorMessages, fromDate, "Please enter fromdate");
	 * addError(errorMessages, toDate, "Please enter toDate");
	 * 
	 * return errorMessages;
	 * 
	 * }
	 */
	/*
	 * @Override public Set<String> validateResetPasswordRequest(int userId, String
	 * currentPassword, String newPassword) { Set<String> errorMessages = new
	 * HashSet<String>();
	 * 
	 * addError(errorMessages, userId, "Please enter userid");
	 * addError(errorMessages, currentPassword, "Please enter currentPassword");
	 * addError(errorMessages, newPassword, "Please enter newPassword");
	 * 
	 * return errorMessages; }
	 */
	@Override
	public Set<String> validateDeleteLibraryRequest(int id) {
		return validateGetLibraryRequest(id);
	}

	@Override
	public Set<String> validateEditLibraryRequest(int id) {
		// TODO Auto-generated method stub
		return validateGetLibraryRequest(id);
	}

	/*
	 * @Override public Set<String> validateGetLibraryRequest(int id) { Set<String>
	 * errorMessages = new HashSet<String>();
	 * 
	 * addError(errorMessages, id, "Please enter valid employeeId");
	 * 
	 * return errorMessages; }
	 */
	/*
	 * public static Set<String> addError(Set<String> errorMessages, int value,
	 * String errorMessage) {
	 * 
	 * if (value <= 0) { errorMessages.add(errorMessage); }
	 * 
	 * return errorMessages; }
	 * 
	 * @Override public Set<String> validateEditLibraryRequest(int id) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public Set<String> validateDeleteLibraryRequest(int id) { // TODO
	 * Auto-generated method stub return null; }
	 */
}
