package com.rs.fer.service;

import com.rs.fer.model.Expense;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.request.UserVO;
import com.rs.fer.response.AddExpenseResponse;
import com.rs.fer.response.DeleteExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.ExpenseReportResponse;
import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
import com.rs.fer.response.GetUserResponse;
import com.rs.fer.response.LoginResponse;
import com.rs.fer.response.RegistrationResponse;
import com.rs.fer.response.ResetPasswordResponse;
import com.rs.fer.response.UpdateUserResponse;

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
}
