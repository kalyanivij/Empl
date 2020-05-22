package com.rs.eis.validation;

import java.util.Set;

public interface ValidationUtil {
	// Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

	Set<String> validateGetExpenseRequest(int expenseId);

	Set<String> validateGetExpensesRequest(int userId);

	Set<String> validateExpenseReportRequest(int userId, String type, String fromDate, String toDate);

	Set<String> validateResetPasswordRequest(int userId, String currentPassword, String newPassword);

	Set<String> validateDeleteExpenseRequest(int expenseId);

	Set<String> validateGetUserRequest(int userId);

	static Set<String> validateDeletevisaRequest(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	// Set<String> validateUpdateUserRequest(UserVO userVO);

}
