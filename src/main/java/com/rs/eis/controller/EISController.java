package com.rs.eis.controller;

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

import com.rs.eis.repository.ExpenseRepository;
import com.rs.eis.repository.RelationRepository;
import com.rs.eis.request.RegistrationVO;
import com.rs.eis.request.UserVO;
import com.rs.eis.response.AddExpenseResponse;
import com.rs.eis.response.AddRelationResponse;
import com.rs.eis.response.AddResponse;
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
import com.rs.eis.validation.ValidationUtil;
import com.rs.eis.model.Expense;
import com.rs.eis.model.Relation;

@RestController
@RequestMapping("/api")
public class EISController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	RelationRepository relationRepository;
	
	

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

	@PostMapping("/expense")
	public AddExpenseResponse addExpense(@Valid @RequestBody Expense expense) {
		return ferService.addExpense(expense);
	}

	@PutMapping("/expense/{id}")
	public EditExpenseResponse editExpense(@PathVariable("id") int Id, @Valid @RequestBody Expense expense) {
		return ferService.editExpense(expense);
	}

	@GetMapping("/expense/{id}")
	public GetExpenseResponse getExpenseById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetExpenseRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getExpenseById(id);
		}
	}

	@GetMapping("/expenses/{userId}")
	public GetExpensesResponse getExpenses(@PathVariable("userId") int userId) {
		Set<String> errorMessages = validationUtil.validateGetExpensesRequest(userId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetExpensesResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getExpenses(userId);
		}
	}

	@GetMapping("/{userId}/expense/report")
	public ExpenseReportResponse expenseReport(@PathVariable("userId") int userId, @RequestParam String type,
			@RequestParam String fromDate, @RequestParam String toDate) {
		Set<String> errorMessages = validationUtil.validateExpenseReportRequest(userId, type, fromDate, toDate);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new ExpenseReportResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.expenseReport(userId, type, fromDate, toDate);
		}
	}

	@DeleteMapping("/expense/{expenseId}")
	public DeleteExpenseResponse deleteExpense(@PathVariable(value = "expenseId") int expenseId) {
		Set<String> errorMessages = validationUtil.validateDeleteExpenseRequest(expenseId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.deleteExpense(expenseId);
		}
	}

	@PutMapping("/reset/{userId}")
	public ResetPasswordResponse reset(@PathVariable(value = "userId") int userId, @RequestParam String currentPassword,
			@RequestParam String newPassword) {
		Set<String> errorMessages = validationUtil.validateResetPasswordRequest(userId, currentPassword, newPassword);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.resetPassword(userId, currentPassword, newPassword);
		}
	}

	@GetMapping("/user/{id}")
	public GetUserResponse getUser(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetUserRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetUserResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getUser(id);
		}
	}

	@PutMapping("/user")
	public UpdateUserResponse update(@RequestBody UserVO userVO) {
		Set<String> errorMessages = validationUtil.validateUpdateUserRequest(userVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.updateUser(userVO);
		}
	}

	@PostMapping("/relation")
	public AddRelationResponse addrelation(@Valid @RequestBody Relation relation) {

		return ferService.addrelationresponse(relation);
	}
	
@GetMapping("/relation/{relationid}")
public GetRelationResponse getRelationById(@PathVariable("relationid") int relationid) {
	Set<String> errorMessages = validationUtil.validateRelationRequest(relationid);
	if (!CollectionUtils.isEmpty(errorMessages)) {
		return new GetRelationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
	} else {
		return ferService.getrelationById(relationid);
	}
}

@DeleteMapping("/relation/{relationId}")
public DeleteRelationResponse deleteRelation(@PathVariable(value = "relationId") int relationId) {
	Set<String> errorMessages = validationUtil.validateDeleteRelationRequest(expenseId);
	if (!CollectionUtils.isEmpty(errorMessages)) {
		return new DeleteRelationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
	} else {
	return ferService.deleteRelation(relationId);
	}
}
}




	
	
	
	
	
	



