package com.rs.eis.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.eis.repository.ExpenseRepository;
import com.rs.eis.repository.RelationRepository;
import com.rs.eis.repository.UserRepository;
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
import com.rs.eis.service.FERService;
import com.rs.eis.util.DateUtil;
import com.rs.eis.util.FERUtil;
import com.rs.eis.controller.DeleteRelationResponse;
import com.rs.eis.controller.GetRelationResponse;
import com.rs.eis.model.Expense;
import com.rs.eis.model.Relation;
import com.rs.eis.model.User;

@Service
public class FERServiceImpl implements FERService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	RelationRepository relationRepository;

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
	public AddRelationResponse addrelationresponse(Relation relation) {
		AddRelationResponse response = new AddRelationResponse();
		Optional<Relation> relationObj = relationRepository.findById(relation.getId());

		if (relationObj.isPresent()) {

			relation.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			relation = relationRepository.save(relation);

			response.setRelation(relation);

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
	public GetRelationResponse getrelationById(int relationid) {
		GetRelationResponse response = new GetRelationResponse();
		Optional<Relation> relationObj = relationRepository.findById(relationid);
		if (relationObj.isPresent()) {
			response.setRelation(relationObj.get());
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
	public GetUserResponse getrelation(int relationid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRelationResponse getrelationresponse(int relationid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteRelationResponse deleteRelation(int relationId) {
		DeleteRelationResponse response = new DeleteRelationResponse();

		Optional<Relation> expenseObj = relationRepository.findById(relationId);

		if (relationObj.isPresent()) {
			Relation relation = relationObj.get();
			relationRepository.delete(relation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
		}

		return response;

	}
}
	
	
	