package com.rs.fer.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.model.Perfomance_Review;
import com.rs.fer.model.Expense;
import com.rs.fer.repository.Perfomance_reviewRepository;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.request.RegistrationVO;
import com.rs.fer.request.UserVO;
import com.rs.fer.response.AddPerfomance_reviewResponse;
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
import com.rs.fer.validation.ValidationUtil;


@RestController
@RequestMapping("/api")
public class FERController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	Perfomance_reviewRepository perfomance_reviewRepository;


	private int expenseId;

	@PostMapping("/register")
	public RegistrationResponse userRegistration(@Valid @RequestBody RegistrationVO registrationVO) {

		Set<String> errorMessages = validationUtil.validateRegistrationRequest(registrationVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.registration(registrationVO);
		}
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestParam String userName, @RequestParam String password) {
		return ferService.login(userName, password);
	}

	/*
	 * @PostMapping("/expense") public AddExpenseResponse
	 * addExpense(@Valid @RequestBody Expense expense) { return
	 * ferService.addExpense(expense); }
	 * 
	 * @PutMapping("/expense/{id}") public EditExpenseResponse
	 * editExpense(@PathVariable("id") int Id, @Valid @RequestBody Expense expense)
	 * { return ferService.editExpense(expense); }
	 * 
	 * @GetMapping("/expense/{id}") public GetExpenseResponse
	 * getExpenseById(@PathVariable("id") int id) { Set<String> errorMessages =
	 * validationUtil.validateGetExpenseRequest(id); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages); }
	 * else { return ferService.getExpenseById(id); } }
	 * 
	 * @GetMapping("/expenses/{userId}") public GetExpensesResponse
	 * getExpenses(@PathVariable("userId") int userId) { Set<String> errorMessages =
	 * validationUtil.validateGetExpensesRequest(userId); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages); }
	 * else { return ferService.getExpenses(userId); } }
	 * 
	 * @GetMapping("/{userId}/expense/report") public ExpenseReportResponse
	 * expenseReport(@PathVariable("userId") int userId, @RequestParam String type,
	 * 
	 * @RequestParam String fromDate, @RequestParam String toDate) { Set<String>
	 * errorMessages = validationUtil.validateExpenseReportRequest(userId, type,
	 * fromDate, toDate); if (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * ExpenseReportResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
	 * } else { return ferService.expenseReport(userId, type, fromDate, toDate); } }
	 * 
	 * @DeleteMapping("/expense/{expenseId}") public DeleteExpenseResponse
	 * deleteExpense(@PathVariable(value = "expenseId") int expenseId) { Set<String>
	 * errorMessages = validationUtil.validateDeleteExpenseRequest(expenseId); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
	 * } else { return ferService.deleteExpense(expenseId); } }
	 * 
	 * @PutMapping("/reset/{userId}") public ResetPasswordResponse
	 * reset(@PathVariable(value = "userId") int userId, @RequestParam String
	 * currentPassword,
	 * 
	 * @RequestParam String newPassword) { Set<String> errorMessages =
	 * validationUtil.validateResetPasswordRequest(userId, currentPassword,
	 * newPassword); if (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
	 * } else { return ferService.resetPassword(userId, currentPassword,
	 * newPassword); } }
	 * 
	 * @GetMapping("/user/{id}") public GetUserResponse getUser(@PathVariable("id")
	 * int id) { Set<String> errorMessages =
	 * validationUtil.validateGetUserRequest(id); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * GetUserResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages); } else
	 * { return ferService.getUser(id); } }
	 * 
	 * @PutMapping("/user") public UpdateUserResponse update(@RequestBody UserVO
	 * userVO) { Set<String> errorMessages =
	 * validationUtil.validateUpdateUserRequest(userVO); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages); }
	 * else { return ferService.updateUser(userVO); } }
	 * 
	 * 
	 * 
	 */	
	
	
	   @PostMapping("/perfomance_review") public AddPerfomance_reviewResponse
	   addEmp_awards(@Valid @RequestBody Perfomance_Review perfomance_review) { return
	   ferService.addPerfomance_review(perfomance_review); }
	  

	@GetMapping("/perfomance_review/{employeeid}")
	public GetPerfomance_reviewResponse getEmp_awards(@PathVariable("perfomance_reviewid") int perfomance_review) {
		Set<String> errorMessages = validationUtil.validateGetPerfomance_reviewRequest(perfomance_review);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetPerfomance_reviewResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getPerfomance_reviewByemployeeid(perfomance_review);
		}
	}

	@GetMapping("/{employeeid}/perfomance_review/report")
	public GetPerfomance_reviewResponse emp_awardsReport(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validatePerfomance_reviewReportRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetPerfomance_reviewResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.perfomance_reviewReport(employeeid);
		}
	}

	/*
	 * @DeleteMapping("/perfomance_review/{employeeid}") public
	 * DeleteEmp_awardsResponse deleteEmp_awards(@PathVariable(value = "employeeid")
	 * int employeeid) { Set<String> errorMessages =
	 * validationUtil.validateDeletePerfomance_reviewRequest(employeeid); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * DeleteEmp_awardsResponse(HttpStatus.PRECONDITION_FAILED, "999",
	 * errorMessages); } else { return
	 * ferService.deletePerfomance_review(employeeid); } }
	 */

	
}
