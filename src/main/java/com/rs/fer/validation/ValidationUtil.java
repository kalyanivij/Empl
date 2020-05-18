package com.rs.fer.validation;

import java.util.Set;

import com.rs.fer.request.RegistrationVO;
import com.rs.fer.request.UserVO;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

	Set<String> validateGetExpenseRequest(int expenseId);

	Set<String> validateGetExpensesRequest(int userId);

	Set<String> validateExpenseReportRequest(int userId, String type, String fromDate, String toDate);

	Set<String> validateResetPasswordRequest(int userId, String currentPassword, String newPassword);

	Set<String> validateDeleteExpenseRequest(int expenseId);

	Set<String> validateGetUserRequest(int userId);
	
	Set<String> validateUpdateUserRequest(UserVO userVO);
	
	Set<String> validatePerfomance_reviewReportRequest(int employeeid);

	Set<String> validateDeletePerfomance_reviewRequest(int employeeid);

	Set<String> validateGetPerfomance_reviewRequest(int emp_awards);
	
	//Set<String> validatePerfomance_reviewReportRequest(int employeeid);


		
}