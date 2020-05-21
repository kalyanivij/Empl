package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Allocation;
import com.rs.eis.model.Employee;
import com.rs.eis.model.Family;
import com.rs.eis.model.Insurance;
import com.rs.eis.model.Project;
import com.rs.eis.model.Resume;
import com.rs.eis.repository.AllocationRepository;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.repository.FamilyRepository;
import com.rs.eis.repository.InsuranceRepository;
import com.rs.eis.repository.ProjectRepository;
import com.rs.eis.repository.ResumeRepository;
import com.rs.eis.response.AddAllocationResponse;
import com.rs.eis.response.AddFamilyResponse;
import com.rs.eis.response.AddInsuranceResponse;
import com.rs.eis.response.AddResumeResponse;
import com.rs.eis.response.DeleteAllocationResponse;
import com.rs.eis.response.DeleteFamilyResponse;
import com.rs.eis.response.DeleteInsuranceResponse;
import com.rs.eis.response.DeleteResumeResponse;
import com.rs.eis.response.EditAllocationResponse;
import com.rs.eis.response.EditFamilyResponse;
import com.rs.eis.response.EditInsuranceResponse;
import com.rs.eis.response.EditResumeResponse;
import com.rs.eis.response.GetAllocationResponse;
import com.rs.eis.response.GetAllocationsResponse;
import com.rs.eis.response.GetFamilyResponse;
import com.rs.eis.response.GetInsuranceResponse;
import com.rs.eis.response.GetResumeResponse;
import com.rs.eis.service.EISService;
import com.rs.eis.util.DateUtil;

@Service
public class EISServiceImpl implements EISService {

	@Autowired
	InsuranceRepository insuranceRepository;
	@Autowired
	FamilyRepository familyRepository;
	
	@Autowired
	AllocationRepository allocationRepository;
	@Autowired
	ProjectRepository projectRepository;
	
	
	@Autowired
	ResumeRepository resumeRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	/*
	 * public RegistrationResponse registration(RegistrationVO registrationVO) {
	 * 
	 * RegistrationResponse response = new RegistrationResponse();
	 * 
	 * List<User> users = userRepository.findByEmail(registrationVO.getEmail());
	 * 
	 * if (CollectionUtils.isEmpty(users)) {
	 * 
	 * User user = FERUtil.loadRegistrationVOToUser(registrationVO);
	 * 
	 * user = userRepository.save(user);
	 * 
	 * response.setUser(user);
	 * 
	 * response.setStatusCode("000"); response.setStatus(HttpStatus.OK); } else {
	 * response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("User is already registered"); }
	 * 
	 * return response; }
	 * 
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
	 * 
	 * public LoginResponse login(String userName, String password) {
	 * 
	 * LoginResponse response = new LoginResponse();
	 * 
	 * List<User> users = userRepository.findByUserNameAndPassword(userName,
	 * password);
	 * 
	 * if (!CollectionUtils.isEmpty(users)) {
	 * 
	 * response.setUser(users.get(0));
	 * 
	 * response.setStatusCode("000"); response.setStatus(HttpStatus.OK); } else {
	 * response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("Invalid credentials."); }
	 * 
	 * return response; }
	 * 
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
	 * 
	 * @Override public GetUserResponse getUser(int userid) { GetUserResponse
	 * response = new GetUserResponse(); Optional<User> userObj =
	 * userRepository.findById(userid); if (userObj.isPresent()) {
	 * response.setUser(userObj.get()); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK); } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("No User Found for the given userid"); }
	 * 
	 * return response; }
	 * 
	 * @Override public UpdateUserResponse updateUser(UserVO userVO) {
	 * 
	 * UpdateUserResponse response = new UpdateUserResponse(); Optional<User>
	 * userObj = userRepository.findById(userVO.getUserId()); if
	 * (userObj.isPresent()) { User userdb = userObj.get(); userdb =
	 * FERUtil.loadUpdateUserVOToUser(userVO, userdb); userdb =
	 * userRepository.save(userdb);
	 * 
	 * response.setUser(userdb); response.setStatusCode("000");
	 * response.setStatus(HttpStatus.OK); } else { response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED);
	 * response.setErrorMessage("No User Found for the given userid"); }
	 * 
	 * return response; }
	 */
	@Override
	public AddInsuranceResponse addInsurance(Insurance insurance) {
		AddInsuranceResponse response = new AddInsuranceResponse();
		  
		  Optional<Insurance> insuranceObj = insuranceRepository.findById(insurance.getInsuranceid());
		  
		  if (insuranceObj.isPresent()) {
		  
			
			  insurance.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			 		  insurance =insuranceRepository.save(insurance);
		  
		  response.setInsurance(insurance);
		  
		  response.setStatusCode("000"); response.setStatus(HttpStatus.OK);
		  } else {
		  response.setStatusCode("001");
		  response.setStatus(HttpStatus.PRECONDITION_FAILED);
		  response.setErrorMessage("Invalid Input as employeeId is not present in user table"); }
		  
		  return response;
	}
	@Override
	public AddFamilyResponse addFamily(Family family) {
		AddFamilyResponse response = new AddFamilyResponse();
		  Optional<Family> familyObj = familyRepository.findById(family.getRelationid());
		  
		  if (familyObj.isPresent()) {
		  
		  family.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		  family =familyRepository.save(family);
		  
		  response.setFamily(family);
		  
		  response.setStatusCode("000"); response.setStatus(HttpStatus.OK);
		  } else {
		  response.setStatusCode("001");
		  response.setStatus(HttpStatus.PRECONDITION_FAILED);
		  response.setErrorMessage("Invalid Input as employeeId is not present in user table"); }
	
		  return response;
	}
	
	
	@Override
	public GetInsuranceResponse getInsuranceByemployeeid(int employeeid) {
		GetInsuranceResponse response = new GetInsuranceResponse();
		Optional<Insurance> insuranceObj = insuranceRepository.findById(employeeid);

		if (insuranceObj.isPresent()) {

			response.setInsurance(insuranceObj.get());

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Employeeid is not present in Insurance table");
		}

		return response;
	}

	@Override
	public GetFamilyResponse getFamilyByemployeeid(int employeeid) {
		GetFamilyResponse response = new GetFamilyResponse();
		Optional<Family> familyObj = familyRepository.findById(employeeid);

		if (familyObj.isPresent()) {

			response.setFamily(familyObj.get());

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Employeeid is not present in Family table");
		}

		return response;
	}
	
	@Override
	public GetInsuranceResponse insuranceReport(int employeeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetFamilyResponse familyReport(int employeeid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public EditInsuranceResponse editInsurance(Insurance insurance) {
		EditInsuranceResponse response =new EditInsuranceResponse();
		Optional<Insurance> insuranceObj = insuranceRepository.findById(insurance.getInsuranceid());
		if (insuranceObj.isPresent()) {
			  
			  insurance.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			  insurance =insuranceRepository.save(insurance);
			  
			  response.setInsurance(insurance);
			  
			  response.setStatusCode("000"); response.setStatus(HttpStatus.OK);
			  } else {
			  response.setStatusCode("001");
			  response.setStatus(HttpStatus.PRECONDITION_FAILED);
			  response.setErrorMessage("Invalid Input as employeeId is not present in Insurance table"); }
			  
			  return response;
		}
	@Override
	public EditFamilyResponse editFamily(Family family) {
		EditFamilyResponse response =new EditFamilyResponse();
		Optional<Family> familyObj = familyRepository.findById(family.getRelationid());
		if (familyObj.isPresent()) {
			  
			  family.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			  family =familyRepository.save(family);
			  
			  response.setFamily(family);
			  
			  response.setStatusCode("000"); response.setStatus(HttpStatus.OK);
			  } else {
			  response.setStatusCode("001");
			  response.setStatus(HttpStatus.PRECONDITION_FAILED);
			  response.setErrorMessage("Invalid Input as employeeId is not present in Insurance table");
			  }
			  
			  return response;
		}
	@Override
	public DeleteInsuranceResponse deleteinsurance(int employeeid) {
		DeleteInsuranceResponse response = new DeleteInsuranceResponse();
		Optional<Insurance> insuranceObj = insuranceRepository.findById(employeeid);
		if (insuranceObj.isPresent()) {

			Insurance insurance = insuranceObj.get();
			insuranceRepository.delete(insurance);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Employeeid is not present in Insuranc table");
		}

		return response;
	}
	
	@Override
	public DeleteFamilyResponse deleteFamily(int employeeid) {
		DeleteFamilyResponse response = new DeleteFamilyResponse();
		Optional<Family> familyObj = familyRepository.findById(employeeid);
		if (familyObj.isPresent()) {

			com.rs.eis.model.Family family = familyObj.get();
			familyRepository.delete(family);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Employeeid is not present in Insuranc table");
		}

		return response;
	}
	
	
	@Override
	public AddAllocationResponse addAllocation(Allocation allocation) {
		AddAllocationResponse response = new AddAllocationResponse();

		//Optional<Allocation> allocationObj = allocationRepository.findById(allocation.getProject().getId());
		Optional<Project> allocationObj = projectRepository.findById(allocation.getProjectid());

		if (allocationObj.isPresent()) {

			allocation = allocationRepository.save(allocation);

			response.setAllocation(allocation);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid allocation as projectId is not present in Project table");
		}

		return response;
	}

	@Override
	public EditAllocationResponse editAllocation(Allocation allocation) {
		EditAllocationResponse response = new EditAllocationResponse();

		Optional<Allocation> allocationObj = allocationRepository.findById(allocation.getId());

		if (allocationObj.isPresent()) {

			//expense.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			allocation = allocationRepository.save(allocation);

			response.setAllocation(allocation);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as allocationId is not present in allocation table");
		}

		return response;

	}

	@Override
	public DeleteAllocationResponse deleteAllocation(int projectid) {
		DeleteAllocationResponse response = new DeleteAllocationResponse();

		Optional<Allocation> allocationObj = allocationRepository.findById(projectid);

		if (allocationObj.isPresent()) {
			Allocation allocation = allocationObj.get();
			allocationRepository.delete(allocation);
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
	public GetAllocationResponse getAllocationById(int id) {
		GetAllocationResponse response = new GetAllocationResponse();
		Optional<Allocation> allocationObj = allocationRepository.findById(id);
		if (allocationObj.isPresent()) {
			response.setAllocation(allocationObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No allocation Found for the given allocationid");
		}

		return response;

	}

	@Override
	public GetAllocationsResponse getAllocations(int projectid) {
		GetAllocationsResponse response = new GetAllocationsResponse();
		List<Allocation> allocations = allocationRepository.findByProjectid(projectid);
		if (!allocations.isEmpty()) {
			response.setAllocation(allocations);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as projectId is not present in allocation table");
		}

		return response;
	}


	
	/*
	 * @Override
	 * 
	 * 
	 * public FamilyResponse familyResponse(int employeeid) { FamilyResponse
	 * response = new FamilyResponse(); Optional<Family> familyObj =
	 * familyRepository.findById(employeeid);
	 * 
	 * if (familyObj.isPresent()) {
	 * 
	 * response.setFamily(familyObj.get());
	 * 
	 * response.setStatusCode("000"); response.setStatus(HttpStatus.OK); } else {
	 * response.setStatusCode("001");
	 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
	 * setErrorMessage("Invalid Input as userId is not present in user table"); }
	 * 
	 * return response; }
	 */
	
	

	
	/*
	 * @Override public LoginResponse login(String userName, String password) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public GetExpensesResponse getExpenses(int userId) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ResetPasswordResponse resetPassword(int userid, String
	 * currentPassword, String newPassword) { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public GetUserResponse getUser(int userid) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public UpdateUserResponse updateUser(UserVO userVO) { // TODO
	 * Auto-generated method stub return null; }
	 */

	
	/*
	 * @Override public DeleteInsuranceResponse deleteInsurance(int employeeid) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public GetInsuranceResponse getinsuranceByemployeeid(int
	 * employeeid) { // TODO Auto-generated method stub return null; }
	 */
	
	
	@Override
	public AddResumeResponse addResume(Resume resume) {
		AddResumeResponse response = new AddResumeResponse();

		Optional<Employee> resumeObj = employeeRepository.findById(resume.getEmployeeId());

		if (resumeObj.isPresent()) {

			resume = resumeRepository.save(resume);

			response.setResume(resume);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Resume insertion as employeeId is not present in employee table");
		}

		return response;
	}



	@Override
	public DeleteResumeResponse deleteResume(int reesumeId) {
		DeleteResumeResponse response = new DeleteResumeResponse();

		Optional<Resume> resumeObj = resumeRepository.findById(reesumeId);

		if (resumeObj.isPresent()) {
			Resume resume = resumeObj.get();
			resumeRepository.delete(resume);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in Resume table");
		}

		return response;

	}



	@Override
	public EditResumeResponse editResume(Resume resume) {
		EditResumeResponse response = new EditResumeResponse();

		Optional<Resume> resumeObj = resumeRepository.findById(resume.getId());

		if (resumeObj.isPresent()) {

			//expense.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			resume = resumeRepository.save(resume);

			response.setResume(resume);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as resume is not present in resume table");
		}

		return response;

	}



	@Override
	public GetResumeResponse getResume(int employeeId) {
		GetResumeResponse response = new GetResumeResponse();
		Optional<Resume> resumeObj = resumeRepository.findById(employeeId);
		if (resumeObj.isPresent()) {
			response.setResume(resumeObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No resume Found for the given employeeId");
		}

		return response;

	}

	
	}	
