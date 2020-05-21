package com.rs.eis.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

<<<<<<< HEAD
import com.rs.eis.request.QualificationVO;
=======
import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
import com.rs.eis.validation.ValidationUtil;

@Component
public class ValidationUtilImpl implements ValidationUtil {

<<<<<<< HEAD
	public Set<String> validateQualificationRequest(QualificationVO qualificationVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, qualificationVO.getEducation(), "Please enter education");
		addError(errorMessages, qualificationVO.getCourse(), "Please enter course");

		addError(errorMessages, qualificationVO.getSpecialization(), "Please enter specialization");
		addError(errorMessages, qualificationVO.getUniversity(), "lease enter university");

		addError(errorMessages, qualificationVO.getCourse_type(), "Please enter course_type");
		addError(errorMessages, qualificationVO.getGrade(), "Please enter grade");
		addError(errorMessages, qualificationVO.getMarks(), "Please enter marks");
=======
	@Override
	public Set<String> validateRegistrationRequest(RegistrationVO registrationVO) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, registrationVO.getFirstName(), "Please enter FirstName");
		addError(errorMessages, registrationVO.getLastName(), "Please enter LastName");

		addError(errorMessages, registrationVO.getEmail(), "Please enter Email");
		addError(errorMessages, registrationVO.getMobile(), "Please enter Mobile");

		addError(errorMessages, registrationVO.getUserName(), "Please enter UserName");
		addError(errorMessages, registrationVO.getPassword(), "Please enter Password");

>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
		return errorMessages;
	}

	public static Set<String> addError(Set<String> errorMessages, String value, String errorMessage) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
<<<<<<< HEAD
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

	@Override
	public Set<String> validateDeleteTrainingsRequest(int trainingId) {
=======
	public Set<String> validateGetExpenseRequest(int expenseId) {
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
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
	public Set<String> validateGetInsuranceRequest(int employeeid) {
		Set<String> errorMessages = new HashSet<String>();
		addError(errorMessages, employeeid, "Please enter employeeid");
		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteInsuranceRequest(int employeeid) {
		
		return validateDeleteInsuranceRequest(employeeid);
	}


	@Override
	public Set<String> validateInsuranceReportRequest(int employeeid) {
		Set<String> errorMessages = new HashSet<String>();
		addError(errorMessages, employeeid, "Please enter employeeid");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetFamilyRequest(int employeeid) {
		Set<String> errorMessages = new HashSet<String>();
		addError(errorMessages, employeeid, "Please enter employeeid");
		return errorMessages;
	}

	@Override
	public Set<String> validateFamilyReportRequest(int employeeid) {
		Set<String> errorMessages = new HashSet<String>();
		addError(errorMessages, employeeid, "Please enter employeeid");
		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteFamilyRequest(int employeeid) {

		return validateDeleteInsuranceRequest(employeeid);
	}

}
