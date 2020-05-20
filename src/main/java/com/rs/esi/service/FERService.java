package com.rs.esi.service;

import org.springframework.stereotype.Service;

import com.rs.esi.model.Emp_awards;
import com.rs.esi.model.Expense;
import com.rs.esi.request.RegistrationVO;
import com.rs.esi.request.UserVO;
import com.rs.esi.response.AddEmp_awardsResponse;
import com.rs.esi.response.DeleteEmp_awardsResponse;
import com.rs.esi.response.EditEmp_awardsResponse;
import com.rs.esi.response.Emp_awardsReportResponse;
import com.rs.esi.response.GetEmp_awardsResponse;
import com.rs.esi.response.GetUserResponse;
import com.rs.esi.response.LoginResponse;
import com.rs.esi.response.RegistrationResponse;
import com.rs.esi.response.ResetPasswordResponse;
import com.rs.esi.response.UpdateUserResponse;
@Service
public interface FERService {
	RegistrationResponse registration(RegistrationVO registrationVO);

	LoginResponse login(String userName, String password);

	/*
	 * AddExpenseResponse addExpense(Expense expense);
	 * 
	 * EditExpenseResponse editExpense(Expense expense);
	 * 
	 * GetExpenseResponse getExpenseById(int id);
	 * 
	 * GetExpensesResponse getExpenses(int userId);
	 * 
	 * ExpenseReportResponse expenseReport(int userid, String type, String fromDate,
	 * String toDate);
	 * 
	 * ResetPasswordResponse resetPassword(int userid, String currentPassword,
	 * String newPassword);
	 * 
	 * DeleteExpenseResponse deleteExpense(int expenseId);
	 */

	GetUserResponse getUser(int userid);

	UpdateUserResponse updateUser(UserVO userVO);

	GetEmp_awardsResponse getEmp_awardsByemployeeid(int employeeid);

	AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards);

	EditEmp_awardsResponse editEmp_awards(Emp_awards emp_awards);

	/*
	 * Emp_awardsReportResponse emp_awardsReport(int awardsid, String Date, String
	 * created, String updated);
	 */
	
	  DeleteEmp_awardsResponse deleteEmp_awards(int employeeid);
	 
}
