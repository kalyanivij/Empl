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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Family;
import com.rs.eis.model.Insurance;
import com.rs.eis.repository.InsuranceRepository;
import com.rs.eis.response.AddFamilyResponse;
import com.rs.eis.response.AddInsuranceResponse;
import com.rs.eis.response.DeleteFamilyResponse;
import com.rs.eis.response.DeleteInsuranceResponse;
import com.rs.eis.response.GetFamilyResponse;
import com.rs.eis.response.GetInsuranceResponse;
import com.rs.eis.service.FERService;
import com.rs.eis.validation.ValidationUtil;

@RestController
@RequestMapping("/api")
public class FERController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	InsuranceRepository inuranceRepository;

	/*
	 * @PostMapping("/register") public RegistrationResponse
	 * userRegistration(@Valid @RequestBody RegistrationVO registrationVO) {
	 * 
	 * Set<String> errorMessages =
	 * validationUtil.validateRegistrationRequest(registrationVO); if
	 * (!CollectionUtils.isEmpty(errorMessages)) { return new
	 * RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages); }
	 * else { return ferService.registration(registrationVO); } }
	 */
	/*
	 * @PostMapping("/insurence") public InsuranceResponse insurance(@RequestParam
	 * ("id") int Id, @RequestParam int employeeid) { return
	 * ferService.insuranceResponse(employeeid); }
	 * 
	 * @PostMapping("/family") public FamilyResponse family(@Valid @RequestBody
	 * ("id") int Id, @RequestParam int employeeid) { return
	 * ferService.familyResponse(employeeid); }
	 */

	/*
	 * @PutMapping("/insurance/{employeeid}") public EditExpenseResponse
	 * editExpense(@PathVariable("id") int Id, @RequestParam int employeeid) {
	 * return ferService.editExpense(expense); }
	 */
	@PostMapping("/insurence")
	public AddInsuranceResponse addinsurance(@Valid @RequestBody Insurance insuranse) {
		return ferService.addInsurance(insuranse);
	}

	@PostMapping("/family")
	public AddFamilyResponse addfamily(@Valid @RequestBody Family family) {
		return ferService.addfamily(family);
	}

	@GetMapping("/Insuranceid")
	public GetInsuranceResponse getInsurence(@PathVariable("insuranceid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateGetInsuranceRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetInsuranceResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getInsuranceByemployeeid(employeeid);
		}
	}

	@GetMapping("/relationid")
	public GetFamilyResponse getFamily(@PathVariable("relationid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateGetFamilyRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetFamilyResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getFamilyByemployeeid(employeeid);
		}
	}

	@GetMapping("/{emloyeeid}Insurance/report")
	public GetInsuranceResponse getInsurenceReport(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateInsuranceReportRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetInsuranceResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.insuranceReport(employeeid);
		}
	}

	@GetMapping("/{emloyeeid}Family/report")
	public GetFamilyResponse getFamilyReport(@PathVariable("employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateFamilyReportRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetFamilyResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.familyReport(employeeid);
		}
	}

	@DeleteMapping("/Insurance/{employeeid}")
	public DeleteInsuranceResponse deleteInsurance(@PathVariable(value = "employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateDeleteInsuranceRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteInsuranceResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {

			return ferService.deleteinsurance(employeeid);
		}
	}

	@DeleteMapping("/Family/{employeeid}")
	public DeleteFamilyResponse deleteFamily(@PathVariable(value = "employeeid") int employeeid) {
		Set<String> errorMessages = validationUtil.validateDeleteFamilyRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteFamilyResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {

			return ferService.deleteFamily(employeeid);
		}
	}

	/*
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
	 * else { return ferService.updateUser(userVO); }
	 */
}
