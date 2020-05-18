package com.rs.eis.service;

import javax.validation.Valid;


import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;
import com.rs.eis.response.AddExpenseResponse;
import com.rs.eis.response.AddRelationResponse;
import com.rs.eis.response.DeleteExpenseResponse;
import com.rs.eis.response.EditExpenseResponse;
import com.rs.eis.response.ExpenseReportResponse;
import com.rs.eis.response.GetExpenseResponse;
import com.rs.eis.response.GetExpensesResponse;
import com.rs.eis.response.GetUserResponse;
import com.rs.eis.response.LoginResponse;
import com.rs.eis.response.RegistrationResponse;
import com.rs.eis.response.ResetPasswordResponse;
import com.rs.eis.response.UpdateUserResponse;
import com.rs.eis.controller.DeleteRelationResponse;
import com.rs.eis.controller.GetRelationResponse;
import com.rs.eis.model.Expense;
import com.rs.eis.model.Relation;

public interface FERService {
	RegistrationResponse registration(RegistrationVO registrationVO);

	LoginResponse login(String userName, String password);

	AddExpenseResponse addExpense(com.rs.eis.model.Expense expense);

	EditExpenseResponse editExpense(com.rs.eis.model.Expense expense);

	GetExpenseResponse getExpenseById(int id);

	GetExpensesResponse getExpenses(int userId);

	ExpenseReportResponse expenseReport(int userid, String type, String fromDate, String toDate);

	ResetPasswordResponse resetPassword(int userid, String currentPassword, String newPassword);

	DeleteExpenseResponse deleteExpense(int expenseId);

	GetUserResponse getUser(int userid);
	
	UpdateUserResponse updateUser(UserVO userVO);
	
	GetUserResponse getrelation(int relationid);

	AddRelationResponse addrelationresponse(Relation relation);
	
	GetRelationResponse getrelationresponse(int relationid);

	GetRelationResponse getrelationById(int relationid);

	DeleteRelationResponse deleteRelation(int relationId);

	
}
