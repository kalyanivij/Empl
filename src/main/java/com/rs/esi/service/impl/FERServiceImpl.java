package com.rs.esi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.model.Emp_awards;
import com.rs.fer.model.Expense;
import com.rs.fer.model.User;
import com.rs.fer.repository.Emp_awardsRepository;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.request.UserVO;
import com.rs.fer.response.AddEmp_awardsResponse;
/*import com.rs.fer.response.AddExpenseResponse;
*/import com.rs.fer.response.DeleteEmp_awardsResponse;
import com.rs.fer.response.Emp_awardsReportResponse;
/*import com.rs.fer.response.DeleteExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.ExpenseReportResponse;
*/import com.rs.fer.response.GetEmp_awardsResponse;
/*import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
*/import com.rs.fer.response.GetUserResponse;
import com.rs.fer.response.LoginResponse;
import com.rs.fer.response.RegistrationResponse;
import com.rs.fer.response.ResetPasswordResponse;
import com.rs.fer.response.UpdateUserResponse;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DateUtil;
import com.rs.fer.util.FERUtil;

@Service
public class FERServiceImpl implements FERService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ExpenseRepository expenseRepository;
	@Autowired
	Emp_awardsRepository emp_awardsRepository;

	public RegistrationResponse registration(RegistrationVO registrationVO) {

		RegistrationResponse response = new RegistrationResponse();

		List<User> users = userRepository.findByEmail(registrationVO.getEmail());

		if (CollectionUtils.isEmpty(users)) {

			User user = FERUtil.loadRegistrationVOToUser(registrationVO);

			user = userRepository.save(user);

			response.setUser(user);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("User is already registered");
		}

		return response;
	}

	/*
	 * public AddExpenseResponse addExpense(Expense expense) {
	 * 
	 * AddExpenseResponse response = new AddExpenseResponse();
	 * 
	 * Optional<User> userObj = userRepository.findById(expense.getUserId());
	 * 
	 * if (userObj.isPresent()) {
	 * 
	 * expense.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss")); expense =
	 * expenseRepository.save(expense);
	 * 
	 * response.setExpense(expense);
	 * 
	 * response.setStatusCode("000"); response.setStatus(HttpStatus.OK); } else {
	 * response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
	 * setErrorMessage("Invalid Input as userId is not present in user table"); }
	 * 
	 * return response; }
	 */

	public LoginResponse login(String userName, String password) {

		LoginResponse response = new LoginResponse();

		List<User> users = userRepository.findByUserNameAndPassword(userName, password);

		if (!CollectionUtils.isEmpty(users)) {

			response.setUser(users.get(0));

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid credentials.");
		}

		return response;
	}

	/*
	 * public EditExpenseResponse editExpense(Expense expense) { EditExpenseResponse
	 * response = new EditExpenseResponse();
	 * 
	 * Optional<Expense> expenseObj = expenseRepository.findById(expense.getId());
	 * 
	 * if (expenseObj.isPresent()) {
	 * 
	 * expense.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss")); expense =
	 * expenseRepository.save(expense);
	 * 
	 * response.setExpense(expense);
	 * 
	 * response.setStatusCode("000"); response.setStatus(HttpStatus.OK); } else {
	 * response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
	 * setErrorMessage("Invalid Input as expenseId is not present in expense table"
	 * ); }
	 * 
	 * return response; }
	 * 
	 * @Override public GetExpenseResponse getExpenseById(int id) {
	 * GetExpenseResponse response = new GetExpenseResponse(); Optional<Expense>
	 * expenseObj = expenseRepository.findById(id); if (expenseObj.isPresent()) {
	 * response.setExpense(expenseObj.get()); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK); } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("No Expense Found for the given expenseid"); }
	 * 
	 * return response; }
	 * 
	 * @Override public List<Expense> getExpenses(Integer userId) { ExpenseResponse
	 * response=new ExpenseResponse(); List<Expense> expenseObj =
	 * expenseRepository.findAllById(userId); if (expenseObj.isEmpty()) {
	 * response.setExpense(expenseObj.get(0)); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK); } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
	 * setErrorMessage("Invalid Input as expenseId is not present in expense table"
	 * ); }
	 * 
	 * return response; }
	 * 
	 * 
	 * @Override public GetExpensesResponse getExpenses(int userId) {
	 * GetExpensesResponse response = new GetExpensesResponse(); List<Expense>
	 * expenses = expenseRepository.findByUserId(userId); if (!expenses.isEmpty()) {
	 * response.setExpenses(expenses); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK); } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
	 * setErrorMessage("Invalid Input as expenseId is not present in expense table"
	 * ); }
	 * 
	 * return response; }
	 * 
	 * @Override public ExpenseReportResponse expenseReport(int userid, String type,
	 * String fromDate, String toDate) { ExpenseReportResponse response = new
	 * ExpenseReportResponse(); //Expense exp = new Expense(); List<Expense>
	 * expenses = expenseRepository.findByUserIdAndTypeAndDateBetween(userid, type,
	 * fromDate, toDate); if (!expenses.isEmpty()) {
	 * 
	 * response.setExpenses(expenses); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK);
	 * 
	 * } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("No expenses found for the given input.."); }
	 * 
	 * return response; }
	 * 
	 * @Override public ResetPasswordResponse resetPassword(int userid, String
	 * currentPassword, String newPassword) { ResetPasswordResponse response = new
	 * ResetPasswordResponse(); Optional<User> userObj =
	 * userRepository.findById(userid); if (userObj.isPresent()) { User user =
	 * userObj.get(); if (user.getPassword().equals(currentPassword)) {
	 * user.setPassword(newPassword); userRepository.save(user);
	 * response.setStatusCode("000"); response.setStatus(HttpStatus.OK); } else {
	 * response.setStatusCode("002");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.setErrorMessage(
	 * "Password which is on the account and input for current password are not matching."
	 * ); }
	 * 
	 * } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("User is not found with the given input."); } return
	 * response; }
	 * 
	 * @Override public DeleteExpenseResponse deleteExpense(int expenseId) {
	 * DeleteExpenseResponse response = new DeleteExpenseResponse();
	 * 
	 * Optional<Expense> expenseObj = expenseRepository.findById(expenseId);
	 * 
	 * if (expenseObj.isPresent()) { Expense expense = expenseObj.get();
	 * expenseRepository.delete(expense); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK); } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
	 * setErrorMessage("Invalid Input as expenseId is not present in expense table"
	 * ); }
	 * 
	 * return response;
	 * 
	 * }
	 */
	@Override
	public GetUserResponse getUser(int userid) {
		GetUserResponse response = new GetUserResponse();
		Optional<User> userObj = userRepository.findById(userid);
		if (userObj.isPresent()) {
			response.setUser(userObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No User Found for the given userid");
		}

		return response;
	}

	@Override
	public UpdateUserResponse updateUser(UserVO userVO) {

		UpdateUserResponse response = new UpdateUserResponse();
		Optional<User> userObj = userRepository.findById(userVO.getUserId());
		if (userObj.isPresent()) {
			User userdb = userObj.get();
			userdb = FERUtil.loadUpdateUserVOToUser(userVO, userdb);
			userdb = userRepository.save(userdb);

			response.setUser(userdb);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No User Found for the given userid");
		}

		return response;
	}

	@Override
	public AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards) {

		AddEmp_awardsResponse response = new AddEmp_awardsResponse();

		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(emp_awards.getawardsid());

		if (emp_awardsObj.isPresent()) {

			emp_awards.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			emp_awards = emp_awardsRepository.save(emp_awards);

			response.setEmp_awards(emp_awards);

			response.setStatusCode("000");

			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Emp_awards are  not present in awards table");
		}

		return response;
	}

	@Override
	public GetEmp_awardsResponse getEmp_awardsByemployeeid(int awardsid) {
		GetEmp_awardsResponse response = new GetEmp_awardsResponse();
		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(awardsid);
		if (emp_awardsObj.isPresent()) {

			response.setEmp_awards(emp_awardsObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Employee award Found for the given employeeid");
		}

		return response;

	}

	@Override
	public GetEmp_awardsResponse emp_awardsReport(int awardsid) {
				 String fromDate, String toDate) {Emp_awardsReportResponse response = new
						 Emp_awardsReportResponse(); 
				 emp_awards = expenseRepository.findByUserIdAndTypeAndDateBetween(name, date, employeeid, awardsid); if (!emp_awards.isEmpty()) {
				  
				  response.setEmp_awards(emp_awards); response.setStatusCode("000");
				  response.setStatus(HttpStatus.OK);
				  
				  } else { response.setStatusCode("001");
				  response.setStatus(HttpStatus.PRECONDITION_FAILED);
				  response.setErrorMessage("No expenses found for the given input.."); }
				  
				  return response; }

	@Override
	public DeleteEmp_awardsResponse deleteEmp_awards(int employeeid) {
		// TODO Auto-generated method stub
		DeleteEmp_awardsResponse response = new DeleteEmp_awardsResponse();

		Optional<Emp_awards> emp_awardsObj = emp_awardsRepository.findById(employeeid);

		if (emp_awardsObj.isPresent()) {
			Emp_awards emp_awards = emp_awardsObj.get();
			emp_awardsRepository.delete(emp_awards);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as EmployeeId is not present in Emp_awards table");
		}

		return response;

	}

}
