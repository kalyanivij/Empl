package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
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
import com.rs.eis.request.AllocationVO;
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
=======
import com.rs.eis.model.Country;
import com.rs.eis.model.State;
import com.rs.eis.repository.CountryRepository;
import com.rs.eis.repository.StateRepository;
import com.rs.eis.response.CountryResponse;
import com.rs.eis.response.DeleteCountryResponse;
import com.rs.eis.response.DeleteStateResponse;
import com.rs.eis.response.EditCountryResponse;
import com.rs.eis.response.EditStateResponse;
import com.rs.eis.response.GetCountryResponse;
import com.rs.eis.response.GetStateResponse;
import com.rs.eis.response.StateResponse;
>>>>>>> branch 'master' of git@github.com:kalyanivij/Empl.git
import com.rs.eis.service.EISService;

@Service
public class EISServiceImpl implements EISService {

	@Autowired

	EISService eisService;

	@Autowired

	CountryRepository countryRepository;

	@Autowired
	StateRepository stateRepository;

	public StateResponse addState(State state) {
		StateResponse response = new StateResponse();
		state = stateRepository.save(state);
		/* if (!state.isEmpty()) { */
		response.setState(state);
		response.setStatusCode("000");
		response.setStatus(HttpStatus.OK);
		/*
		 * } else { response.setStatusCode("001");
		 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
		 * setErrorMessage("Invalid Input as name is not present in state table"); }
		 */
		return response;
	}

	@Override
	public CountryResponse addCountry(Country country) {
		CountryResponse response = new CountryResponse();
		country = countryRepository.save(country);
		/* if (!state.isEmpty()) { */
		response.setCountry(country);
		response.setStatusCode("000");
		response.setStatus(HttpStatus.OK);
		/*
		 * } else { response.setStatusCode("001");
		 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
		 * setErrorMessage("Invalid Input as name is not present in state table"); }
		 */
		return response;
	}

	@Override
	public GetStateResponse getStateById(int id) {
		GetStateResponse response = new GetStateResponse();
		Optional<State> state = stateRepository.findById(id);
		if (state.isPresent()) {
			response.setState(state.get());

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in user table");
		}

		return response;
	}

	@Override
	public DeleteStateResponse deleteStateById(int id) {
		DeleteStateResponse response = new DeleteStateResponse();
		Optional<State> state = stateRepository.findById(id);
		if (state.isPresent()) {
			State State = state.get();
			stateRepository.delete(State);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public EditStateResponse editState(State state) {
		EditStateResponse response = new EditStateResponse();
		Optional<State> stateObj = stateRepository.findById(state.getId());
		if (stateObj.isPresent()) {

			state = stateRepository.save(state);
			response.setState(state);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as name is not present in state table");

		}

		return response;
	}

	@Override

	public GetCountryResponse getCountryById(int id) {
		GetCountryResponse response = new GetCountryResponse();
		Optional<Country> country = countryRepository.findById(id);
		if (country.isPresent()) {
			response.setCountry(country.get());

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);

			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public DeleteCountryResponse deleteCountryById(int id) {
		DeleteCountryResponse response = new DeleteCountryResponse();
		Optional<Country> country = countryRepository.findById(id);
		if (country.isPresent()) {
			Country Country = country.get();
			countryRepository.delete(Country);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");

		}
		return response;
	}

	@Override

	public EditCountryResponse editCountry(Country country) {
		EditCountryResponse response = new EditCountryResponse();
		Optional<Country> countryObj = countryRepository.findById(country.getId());
		if (countryObj.isPresent()) {
			
			country=countryRepository.save(country);
			response.setCountry(country);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as name is not present in state table");
		}

		return response;

	}
<<<<<<< HEAD

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
		Optional<Project> projectObj = projectRepository.findById(allocation.getProjectid());

		if (projectObj.isPresent()) {

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
