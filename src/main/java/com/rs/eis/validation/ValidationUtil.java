package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

	Set<String> validateGetExpenseRequest(int expenseId);

	Set<String> validateGetExpensesRequest(int userId);

	Set<String> validateExpenseReportRequest(int userId, String type, String fromDate, String toDate);

	Set<String> validateResetPasswordRequest(int userId, String currentPassword, String newPassword);

	Set<String> validateDeleteExpenseRequest(int expenseId);

	Set<String> validateGetUserRequest(int userId);
	
	Set<String> validateUpdateUserRequest(UserVO userVO);



	Set<String> validateExperienceRequest(int employeeid);

	Set<String> validateTechnologyRequest(int id);

	Set<String> validateDeleteTechnologyRequest(int id);
}
