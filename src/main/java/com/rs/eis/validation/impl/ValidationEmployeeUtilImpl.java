package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.request.AddEmployeeVO;
import com.rs.eis.validation.ValidationEmployeeUtil;

@Component
public class ValidationEmployeeUtilImpl implements ValidationEmployeeUtil {

	@Override
	public Set<String> validateAddEmployeeRequest(AddEmployeeVO addEmployeeVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, addEmployeeVO.getFirstName(), "Please enter FirstName");
		addError(errorMessages, addEmployeeVO.getLastName(), "Please enter LastName");
		addError(errorMessages, addEmployeeVO.getAadharNo(), "Please enter AadharNo");
		addError(errorMessages, addEmployeeVO.getPanNo(), "Please enter PanNo");
		addError(errorMessages, addEmployeeVO.getDateOfBirth(), "Please enter DateOfBirth");
		addError(errorMessages, addEmployeeVO.getBloodGroup(), "Please enter BloodGroup");
		addError(errorMessages, addEmployeeVO.getPassportNo(), "Please enter PassportNo");
		addError(errorMessages, addEmployeeVO.getGender(), "Please enter Gender");
		addError(errorMessages, addEmployeeVO.getDifferentlyAbled(), "Please enter if DifferentlyAbled or not");

		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetEmployeeRequest(int id) {
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
	public Set<String> validateDeleteEmployeeRequest(int id) {
		return validateGetEmployeeRequest(id);
	}

	@Override
	public Set<String> validateEditEmployeeRequest(int id) {
		// TODO Auto-generated method stub
		return validateGetEmployeeRequest(id);
	}


	/*
	 * @Override public Set<String> validateUpdateEmployeeRequest(EmployeeVO
	 * employeeVO) {
	 * 
	 * Set<String> errorMessages = new HashSet<String>();
	 * 
	 * addError(errorMessages, employeeVO.getFirstName(), "Please enter FirstName");
	 * addError(errorMessages, employeeVO.getLastName(), "Please enter LastName");
	 * addError(errorMessages, employeeVO.getAadharNo(), "Please enter AadharNo");
	 * addError(errorMessages, employeeVO.getPanNo(), "Please enter PanNo");
	 * addError(errorMessages, employeeVO.getDateOfBirth(),
	 * "Please enter DateOfBirth"); addError(errorMessages,
	 * employeeVO.getBloodGroup(), "Please enter BloodGroup");
	 * addError(errorMessages, employeeVO.getPassportNo(),
	 * "Please enter PassportNo"); addError(errorMessages, employeeVO.getGender(),
	 * "Please enter Gender"); addError(errorMessages,
	 * employeeVO.getDifferentlyAbled(), "Please enter if DifferentlyAbled or not");
	 */

		/*
		  if (userVO.getAddressVo() != null &&
		  !userVO.getAddressVo().getLineOne().isEmpty()) { addError(errorMessages,
		  userVO.getAddressVo().getCity(), "Please enter City");
		  addError(errorMessages, userVO.getAddressVo().getPostal(),
		  "Please enter Postalcode");
		  
		  addError(errorMessages, userVO.getAddressVo().getCountry(),
		  "Please enter Country"); addError(errorMessages,
		  userVO.getAddressVo().getState(), "Please enter State"); }
		 
		return errorMessages;*/

	}


