package com.rs.fer.service;

import javax.validation.Valid;

import com.rs.eis.model.Expense;
import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;
import com.rs.eis.response.AddExpenseResponse;
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
import com.rs.fer.model.Pf;
import com.rs.fer.model.Transportation;
import com.rs.fer.response.AddPfResponse;
import com.rs.fer.response.AddTransportationResponse;
import com.rs.fer.response.DeletePfResponse;
import com.rs.fer.response.DeleteTransportationResponse;
import com.rs.fer.response.GetPfResponse;
import com.rs.fer.response.GetTransportationResponse;

public interface FERService {
	RegistrationResponse registration(RegistrationVO registrationVO);

	LoginResponse login(String userName, String password);

	AddExpenseResponse addExpense(Expense expense);

	EditExpenseResponse editExpense(Expense expense);

	GetExpenseResponse getExpenseById(int id);

	GetExpensesResponse getExpenses(int userId);

	ExpenseReportResponse expenseReport(int userid, String type, String fromDate, String toDate);

	ResetPasswordResponse resetPassword(int userid, String currentPassword, String newPassword);

	DeleteExpenseResponse deleteExpense(int expenseId);

	GetUserResponse getUser(int userid);

	UpdateUserResponse updateUser(UserVO userVO);

	AddTransportationResponse addTransportationResponse(@Valid Transportation transportation);

	AddPfResponse addPfResponse(@Valid Pf pf);

	GetTransportationResponse getTransportationById(int id);

	GetPfResponse getpfById(int id);

	DeletePfResponse DeletePf(int id);

	DeleteTransportationResponse DeleteTransportation(int expenseId);

}
