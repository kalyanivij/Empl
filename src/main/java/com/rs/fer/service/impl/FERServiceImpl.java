package com.rs.fer.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.model.Expense;
import com.rs.fer.model.Pf;
import com.rs.fer.model.Transportation;
import com.rs.fer.model.User;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.repository.PfRepository;
import com.rs.fer.repository.TransportationRepository;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.request.UserVO;
import com.rs.fer.response.AddExpenseResponse;
import com.rs.fer.response.AddPfResponse;
import com.rs.fer.response.DeleteExpenseResponse;
import com.rs.fer.response.DeletePfResponse;
import com.rs.fer.response.DeleteTransportationResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.ExpenseReportResponse;
import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
import com.rs.fer.response.GetPfResponse;
import com.rs.fer.response.GetTransportationResponse;
import com.rs.fer.response.GetUserResponse;
import com.rs.fer.response.LoginResponse;
import com.rs.fer.response.PfResponse;
import com.rs.fer.response.RegistrationResponse;
import com.rs.fer.response.ResetPasswordResponse;
import com.rs.fer.response.AddTransportationResponse;
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
	TransportationRepository transportationRepository;
	@Autowired
	PfRepository pfRepository;
	private Expense transportation;

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
	public AddTransportationResponse addTransportationResponse(Transportation transportation) {

		AddTransportationResponse response = new AddTransportationResponse();

		Optional<Transportation> transportationObj = transportationRepository.findById(transportation.getId());

		if (transportationObj.isPresent()) {

			transportation.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			transportation = transportationRepository.save(transportation);

			response.setTransportation(transportation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as transportationId is not present in transportation table");
		}

		return response;

	}

	@Override
	public AddPfResponse addPfResponse(@Valid Pf pf) {

		AddPfResponse response = new AddPfResponse();

		Optional<Pf> pfObj = pfRepository.findById(pf.getId());

		if (pfObj.isPresent()) {

			pf.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			pf = pfRepository.save(pf);

			response.setPf(pf);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as transportationId is not present in transportation table");
		}

		return response;

	}

	@Override
	public DeleteTransportationResponse DeleteTransportation(int Id) {

		DeleteTransportationResponse response = new DeleteTransportationResponse();
		Optional<Transportation> transportationObj = transportationRepository.findById(Id);
		if (transportationObj.isPresent()) {
			Transportation transportation = transportationObj.get();
			transportationRepository.delete(transportation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as suffixId is not present in expense table");
		}

		return response;

	}

	@Override
	public DeletePfResponse DeletePf(int id) {
		DeletePfResponse response = new DeletePfResponse();
		Optional<Pf> pfObj = pfRepository.findById(id);
		if (pfObj.isPresent()) {
			Pf pf = pfObj.get();
			pfRepository.delete(pf);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as suffixId is not present in expense table");
		}

		return response;
	}

	@Override
	public GetTransportationResponse getTransportationById(int id) {

		GetTransportationResponse response = new GetTransportationResponse();

		Optional<Transportation> transportationObj = transportationRepository.findById(id);

		if (transportationObj.isPresent()) {

			response.setTransportation(transportationObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as transportationId is not present in transportation table");
		}

		return response;
	}

	@Override
	public GetPfResponse getpfById(int id) {

		GetPfResponse response = new GetPfResponse();

		Optional<Pf> pfObj = pfRepository.findById(id);

		if (pfObj.isPresent()) {

			response.setPf(pfObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as transportationId is not present in transportation table");
		}

		return response;

	}
}
