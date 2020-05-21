package com.rs.eis.validation;

import java.util.Set;

public interface ValidationUtil {
	/*
	 * Set<String> validateRegistrationRequest(RegistrationVO registrationVO);
	 * 
	 * Set<String> validateGetExpenseRequest(int expenseId);
	 * 
	 * Set<String> validateGetExpensesRequest(int userId);
	 * 
	 * Set<String> validateExpenseReportRequest(int userId, String type, String
	 * fromDate, String toDate);
	 * 
	 * Set<String> validateResetPasswordRequest(int userId, String currentPassword,
	 * String newPassword);
	 * 
	 * Set<String> validateDeleteExpenseRequest(int expenseId);
	 * 
	 * Set<String> validateGetUserRequest(int userId);
	 * 
	 * Set<String> validateUpdateUserRequest(UserVO userVO);
	 */

	Set<String> validateGetDesignationRequest(int id);

	Set<String> validateDeleteDesignationRequest(int id);

	Set<String> validatePutDesignationRequest(int id);

	Set<String> validateDeleteEmp_DesignationRequest(int id);

	Set<String> validateDeleteSalaryRequest(int id);

}
