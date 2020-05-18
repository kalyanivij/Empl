package com.rs.eis.validation;

import java.util.Set;


import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;
import com.rs.eis.response.AddRelationResponse;
import com.rs.eis.model.Relation;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

	Set<String> validateGetExpenseRequest(int expenseId);

	Set<String> validateGetExpensesRequest(int userId);

	Set<String> validateExpenseReportRequest(int userId, String type, String fromDate, String toDate);

	Set<String> validateResetPasswordRequest(int userId, String currentPassword, String newPassword);

	Set<String> validateDeleteExpenseRequest(int expenseId);

	Set<String> validateGetUserRequest(int userId);
	
	Set<String> validateUpdateUserRequest(UserVO userVO);
	
	Set<String> validateRelationRequest(int relationid);

	Set<String> validateDeleteRelationRequest(int expenseId);

}
