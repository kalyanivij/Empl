package com.rs.fer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.model.Expense;
import com.rs.fer.model.Experience;
import com.rs.fer.model.Technology;
import com.rs.fer.model.User;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.repository.ExperienceRepository;
import com.rs.fer.repository.TechnologyRepository;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.request.UserVO;
import com.rs.fer.response.AddExpenseResponse;
import com.rs.fer.response.DeleteExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.ExpenseReportResponse;
import com.rs.fer.response.ExperienceResponse;
import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
import com.rs.fer.response.GetUserResponse;
import com.rs.fer.response.LoginResponse;
import com.rs.fer.response.RegistrationResponse;
import com.rs.fer.response.ResetPasswordResponse;
import com.rs.fer.response.TechnologyResponse;
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

	public AddExpenseResponse addExpense(Expense expense) {

		AddExpenseResponse response = new AddExpenseResponse();

		Optional<User> userObj = userRepository.findById(expense.getUserId());

		if (userObj.isPresent()) {

			expense.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			expense = expenseRepository.save(expense);

			response.setExpense(expense);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as userId is not present in user table");
		}

		return response;
	}

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

	public EditExpenseResponse editExpense(Expense expense) {
		EditExpenseResponse response = new EditExpenseResponse();

		Optional<Expense> expenseObj = expenseRepository.findById(expense.getId());

		if (expenseObj.isPresent()) {

			expense.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			expense = expenseRepository.save(expense);

			response.setExpense(expense);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
		}

		return response;
	}

	@Override
	public GetExpenseResponse getExpenseById(int id) {
		GetExpenseResponse response = new GetExpenseResponse();
		Optional<Expense> expenseObj = expenseRepository.findById(id);
		if (expenseObj.isPresent()) {
			response.setExpense(expenseObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Expense Found for the given expenseid");
		}

		return response;
	}
	/*
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
	 */

	@Override
	public GetExpensesResponse getExpenses(int userId) {
		GetExpensesResponse response = new GetExpensesResponse();
		List<Expense> expenses = expenseRepository.findByUserId(userId);
		if (!expenses.isEmpty()) {
			response.setExpenses(expenses);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
		}

		return response;
	}

	@Override
	public ExpenseReportResponse expenseReport(int userid, String type, String fromDate, String toDate) {
		ExpenseReportResponse response = new ExpenseReportResponse();
		// Expense exp = new Expense();
		List<Expense> expenses = expenseRepository.findByUserIdAndTypeAndDateBetween(userid, type, fromDate, toDate);
		if (!expenses.isEmpty()) {

			response.setExpenses(expenses);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No expenses found for the given input..");
		}

		return response;
	}

	@Override
	public ResetPasswordResponse resetPassword(int userid, String currentPassword, String newPassword) {
		ResetPasswordResponse response = new ResetPasswordResponse();
		Optional<User> userObj = userRepository.findById(userid);
		if (userObj.isPresent()) {
			User user = userObj.get();
			if (user.getPassword().equals(currentPassword)) {
				user.setPassword(newPassword);
				userRepository.save(user);
				response.setStatusCode("000");
				response.setStatus(HttpStatus.OK);
			} else {
				response.setStatusCode("002");
				response.setStatus(HttpStatus.PRECONDITION_FAILED);
				response.setErrorMessage(
						"Password which is on the account and input for current password are not matching.");
			}

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("User is not found with the given input.");
		}
		return response;
	}

	@Override
	public DeleteExpenseResponse deleteExpense(int expenseId) {
		DeleteExpenseResponse response = new DeleteExpenseResponse();

		Optional<Expense> expenseObj = expenseRepository.findById(expenseId);

		if (expenseObj.isPresent()) {
			Expense expense = expenseObj.get();
			expenseRepository.delete(expense);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
		}

		return response;

	}

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
	public ExperienceResponse getexperience(int employeeid) {
		ExperienceResponse response = new ExperienceResponse();
		Optional<Experience> expObj = ExperienceRepository.findById(employeeid);
		if (expObj.isPresent()) {
			response.setExperience(expObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Not valid...");
		}

		return response;

	}

	@Override
	public TechnologyResponse gettechnology(int id) {
		TechnologyResponse response = new TechnologyResponse();
		Optional<Technology> techObj = TechnologyRepository.findById(id);
		if (techObj.isPresent()) {
			response.setTechnology(techObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No technology available on that id...");
		}

		return response;

	}

	// @Override
	/*
	 * public TechnologyResponse addtechnology(Technology technology) {
	 * TechnologyResponse response = new TechnologyResponse();
	 * 
	 * Optional<Technology> techObj = userRepository.findById(techObj.get());
	 * 
	 * if (techObj.isPresent()) {
	 * 
	 * //techObj.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss")); techObj
	 * = expenseRepository.save(techObj);
	 * 
	 * //response.setTechnology(techObj);
	 * 
	 * response.setStatusCode("000"); response.setStatus(HttpStatus.OK); } else {
	 * response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
	 * setErrorMessage("Invalid Input as userId is not present in user table"); }
	 * 
	 * return response; }
	 */

	/*
	 * @Override public TechnologyResponse deletetechnology(Technology technology) {
	 * // TODO Auto-generated method stub return null; }
	 */

}
