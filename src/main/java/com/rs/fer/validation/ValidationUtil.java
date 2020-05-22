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

	Set<String> validateGetTransportationRequest(int Id);

	Set<String> validateGetPfRequest(int Id);

	Set<String> validateDeleteAllocationRequest(int allocationId);

	Set<String> validateGetAllocationRequest(int allocationId);

	Set<String> validateGetAllocationsRequest(int projectId);

	Set<String> validateDeleteResumeRequest(int resumeId);

	Set<String> validateGetResumeRequest(int employeeId);

}
