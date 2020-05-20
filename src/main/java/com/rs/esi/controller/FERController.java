package com.rs.esi.controller;

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

import com.rs.esi.model.Emp_awards;
import com.rs.esi.model.Expense;
import com.rs.esi.repository.Emp_awardsRepository;
import com.rs.esi.repository.ExpenseRepository;
import com.rs.esi.request.RegistrationVO;
import com.rs.esi.request.UserVO;
import com.rs.esi.response.AddEmp_awardsResponse;
import com.rs.esi.response.DeleteEmp_awardsResponse;
import com.rs.esi.response.EditEmp_awardsResponse;
import com.rs.esi.response.GetEmp_awardsResponse;
import com.rs.esi.response.GetUserResponse;
import com.rs.esi.response.LoginResponse;
import com.rs.esi.response.RegistrationResponse;
import com.rs.esi.response.ResetPasswordResponse;
import com.rs.esi.response.UpdateUserResponse;
import com.rs.esi.service.FERService;
import com.rs.esi.validation.ValidationUtil;

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
	Emp_awardsRepository emp_awardsRepository;

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

	@PostMapping("/emp_awards")

	public AddEmp_awardsResponse addEmp_awards(@Valid @RequestBody Emp_awards emp_awards) {
		return ferService.addEmp_awards(emp_awards);
	}

	@GetMapping("/emp_awards/{emp_awardsid}")
	public GetEmp_awardsResponse getEmp_awards(@PathVariable("emp_awardsid") int emp_awardsid) {
		Set<String> errorMessages = validationUtil.validateGetEmp_awardsRequest(emp_awardsid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetEmp_awardsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getEmp_awardsByemployeeid(emp_awardsid);
		}
	}

	@PutMapping("/emp_awards/{id}")
	public EditEmp_awardsResponse editEmp_awards(@PathVariable("id") int id,
			@Valid @RequestBody Emp_awards emp_awards) {
		return ferService.editEmp_awards(emp_awards);
	}

	/*
	 * @GetMapping("/{employeeid}/emp_awards/report") public Emp_awardsResponse
	 * emp_awardsReport(@PathVariable("employeeid") int emp_awardsid) { Set<String>
	 * errorMessages = validationUtil.validateEmp_awardsReportRequest(emp_awardsid);
	 * if (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * GetEmp_awardsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
	 * } else { return ferService.emp_awardsReport(emp_awardsid); } }
	 */

	@DeleteMapping("/emp_awards/{employeeid}")
	public DeleteEmp_awardsResponse deleteEmp_awards(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateDeleteEpm_awardsRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteEmp_awardsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.deleteEmp_awards(employeeid);
		}
	}

}
