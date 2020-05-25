package com.rs.eis.service;
             
import java.util.Date;

import com.rs.eis.model.EmpAssets;
import com.rs.eis.model.Expense;
import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;
import com.rs.eis.response.AddAssetsResponse;
import com.rs.eis.response.AddExpenseResponse;
import com.rs.eis.response.DeleteEmpAssetsResponse;
import com.rs.eis.response.DeleteExpenseResponse;
import com.rs.eis.response.EditExpenseResponse;
import com.rs.eis.response.ExpenseReportResponse;
import com.rs.eis.response.GetAssetsReponse;
import com.rs.eis.response.GetExpenseResponse;
import com.rs.eis.response.GetExpensesResponse;
import com.rs.eis.response.GetUserResponse;
import com.rs.eis.response.LoginResponse;
import com.rs.eis.response.RegistrationResponse;
import com.rs.eis.response.ResetPasswordResponse;
import com.rs.eis.response.UpdateUserResponse;

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
	                               
	AddAssetsResponse addEmpAssets(EmpAssets empassets);
	
	GetAssetsReponse getEmpAsstes(int id);
	
	DeleteEmpAssetsResponse deleteEmpAssetsResponse(int id);
}
