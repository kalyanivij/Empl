package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.model.EmpAssets;
import com.rs.eis.request.EmpAssetsVO;
import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;
import com.rs.eis.validation.ValidationUtil;

@Component           
public class ValidationUtilImpl implements ValidationUtil {

	@Override
	public Set<String> validateRegistrationRequest(RegistrationVO registrationVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, registrationVO.getFirstName(), "Please enter FirstName");
		addError(errorMessages, registrationVO.getLastName(), "Please enter LastName");

		addError(errorMessages, registrationVO.getEmail(), "Please enter Email");
		addError(errorMessages, registrationVO.getMobile(), "Please enter Mobile");

		addError(errorMessages, registrationVO.getUserName(), "Please enter UserName");
		addError(errorMessages, registrationVO.getPassword(), "Please enter Password");

		return errorMessages;                                
	}
                                  
	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetExpenseRequest(int expenseId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, expenseId, "Please enter valid expenseId");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetExpensesRequest(int userId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, userId, "Please enter valid userId");

		return errorMessages;
	}

	@Override
	public Set<String> validateExpenseReportRequest(int userId, String type, String fromDate, String toDate) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, userId, "Please enter userid");
		addError(errorMessages, type, "Please enter type");

		addError(errorMessages, fromDate, "Please enter fromdate");
		addError(errorMessages, toDate, "Please enter toDate");

		return errorMessages;

	}

	@Override
	public Set<String> validateResetPasswordRequest(int userId, String currentPassword, String newPassword) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, userId, "Please enter userid");
		addError(errorMessages, currentPassword, "Please enter currentPassword");
		addError(errorMessages, newPassword, "Please enter newPassword");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteExpenseRequest(int expenseId) {
		return validateGetExpenseRequest(expenseId);
	}

	@Override
	public Set<String> validateGetUserRequest(int userId) {
		return validateGetExpensesRequest(userId);
	}

	@Override
	public Set<String> validateUpdateUserRequest(UserVO userVO) {

		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, userVO.getNameVo().getFirstName(), "Please enter FirstName");
		addError(errorMessages, userVO.getNameVo().getLastName(), "Please enter LastName");

		addError(errorMessages, userVO.getContactVo().getEmail(), "Please enter Email");
		addError(errorMessages, userVO.getContactVo().getMobile(), "Please enter Mobile");

		if (userVO.getAddressVo() != null && !userVO.getAddressVo().getLineOne().isEmpty()) {
			addError(errorMessages, userVO.getAddressVo().getCity(), "Please enter City");
			addError(errorMessages, userVO.getAddressVo().getPostal(), "Please enter Postalcode");

			addError(errorMessages, userVO.getAddressVo().getCountry(), "Please enter Country");
			addError(errorMessages, userVO.getAddressVo().getState(), "Please enter State");
		}

		return errorMessages;

	}

	@Override
	public Set<String> validateEmpAssets(int id, String assetsid, String employeeid, String date) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter FirstName");
		addError(errorMessages, assetsid, "Please enter LastName");

		addError(errorMessages, employeeid, "Please enter Email");
		addError(errorMessages, date, "Please enter Mobile");
		return errorMessages;
	}

	@Override
	public Set<String> validateEmpAssets(EmpAssetsVO empAssetsVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> validateGetEmpAssets(int id) {
		return validateGetEmpAssets(id);

	}

	@Override
	public Set<String> validateDeleteEmpAssets(int id) {
		return validateGetEmpAssets(id);
		
	}

//	@Override
//	public Set<String> validateEmpAssets(EmpAssetsVO empAssetsVO) {
//		
//		return errorMessages;
//	}

	

}
