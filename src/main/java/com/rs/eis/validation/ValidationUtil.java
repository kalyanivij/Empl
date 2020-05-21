package com.rs.eis.validation;

import java.util.Set;

<<<<<<<HEAD
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

	Set<String> validateDeleteTechnologyRequest(int id);=======<<<<<<<HEAD

import com.rs.eis.request.QualificationVO;=======
import com.rs.eis.request.RegistrationVO;
	import com.rs.eis.request.UserVO;>>>>>>>branch'master'

	of https:// github.com/kalyanivij/Empl.git

public interface ValidationUtil {
<<<<<<< HEAD

	Set<String> validateQualificationRequest(QualificationVO qualificationVO);

	Set<String> validateGetQualificatuonRequest(int id);

	Set<String> validateDeleteQualificationRequest(int id);
	
	Set<String> validateUpdateQualificationRequest(int id);
=======
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

	Set<String> validateGetExpenseRequest(int expenseId);

	Set<String> validateGetExpensesRequest(int userId);

	Set<String> validateExpenseReportRequest(int userId, String type, String fromDate, String toDate);

	Set<String> validateResetPasswordRequest(int userId, String currentPassword, String newPassword);

	Set<String> validateDeleteExpenseRequest(int expenseId);

	Set<String> validateGetUserRequest(int userId);
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
	
	Set<String> validateUpdateUserRequest(UserVO userVO);
	
	
	Set<String> validateInsuranceReportRequest(int employeeid);
	
	Set<String> validateDeleteInsuranceRequest(int employeeid);
	
	Set<String> validateGetInsuranceRequest(int employeeid);

	Set<String> validateGetFamilyRequest(int employeeid);

	Set<String> validateFamilyReportRequest(int employeeid);

	Set<String> validateDeleteFamilyRequest(int employeeid);


>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
	
	
	Set<String> validateDeleteAllocationRequest(int allocationId);

Set<String> validateGetAllocationRequest(int allocationId);

Set<String> validateGetAllocationsRequest(int projectId);
}
