package com.rs.fer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.model.Perfomance_Review;
import com.rs.fer.model.Expense;
import com.rs.fer.model.User;
import com.rs.fer.repository.Perfomance_reviewRepository;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.request.UserVO;
import com.rs.fer.response.AddExpenseResponse;
import com.rs.fer.response.AddPerfomance_reviewResponse;
import com.rs.fer.response.DeleteExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.ExpenseReportResponse;
import com.rs.fer.response.GetExpenseResponse;
import com.rs.fer.response.GetExpensesResponse;
/*import com.rs.fer.response.AddExpenseResponse;
/*import com.rs.fer.response.DeleteExpenseResponse;
import com.rs.fer.response.EditExpenseResponse;
import com.rs.fer.response.ExpenseReportResponse;
*/import com.rs.fer.response.GetPerfomance_reviewResponse;
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
	Perfomance_reviewRepository perfomance_reviewRepository;

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
	public GetPerfomance_reviewResponse getPerfomance_reviewByemployeeid(int reviewid) {
		GetPerfomance_reviewResponse response = new GetPerfomance_reviewResponse();
		Optional<Perfomance_Review> perfomance_reviewObj = perfomance_reviewRepository.findById(reviewid);
		if (perfomance_reviewObj.isPresent()) {

			response.setPerfomance_review(perfomance_reviewObj.get());
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
	public GetPerfomance_reviewResponse perfomance_reviewReport(int employeeid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public AddPerfomance_reviewResponse addPerfomance_review(Perfomance_Review perfomance_review) {
		AddPerfomance_reviewResponse response = new AddPerfomance_reviewResponse();

		Optional<Perfomance_Review> perfomance_reviewObj = perfomance_reviewRepository
				.findById(perfomance_review.getreviewid());

				perfomance_review.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		perfomance_review = perfomance_reviewRepository.save(perfomance_review);

		response.setPerfomance_review(perfomance_review);

		response.setStatusCode("000");

		
		return response;

	}

	@Override
	public AddExpenseResponse addExpense(Expense expense) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EditExpenseResponse editExpense(Expense expense) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetExpenseResponse getExpenseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetExpensesResponse getExpenses(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenseReportResponse expenseReport(int userid, String type, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResetPasswordResponse resetPassword(int userid, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteExpenseResponse deleteExpense(int expenseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
