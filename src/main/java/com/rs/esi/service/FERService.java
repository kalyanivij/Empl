package com.rs.esi.service;

import com.rs.esi.model.Expense;
import com.rs.esi.model.Perfomance_Review;
import com.rs.esi.request.RegistrationVO;
import com.rs.esi.request.UserVO;
import com.rs.esi.response.AddExpenseResponse;
import com.rs.esi.response.AddPerfomance_reviewResponse;
import com.rs.esi.response.DeleteExpenseResponse;
import com.rs.esi.response.EditExpenseResponse;
import com.rs.esi.response.ExpenseReportResponse;
import com.rs.esi.response.GetExpenseResponse;
import com.rs.esi.response.GetExpensesResponse;
import com.rs.esi.response.GetPerfomance_reviewResponse;
import com.rs.esi.response.GetUserResponse;
import com.rs.esi.response.LoginResponse;
import com.rs.esi.response.RegistrationResponse;
import com.rs.esi.response.ResetPasswordResponse;
import com.rs.esi.response.UpdateUserResponse;

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
	
	GetPerfomance_reviewResponse getPerfomance_reviewByemployeeid(int reviewid);

	GetPerfomance_reviewResponse perfomance_reviewReport(int employeeid);

	AddPerfomance_reviewResponse addPerfomance_review(Perfomance_Review perfomance_review);

	

	


}
