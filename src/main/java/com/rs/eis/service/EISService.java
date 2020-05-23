package com.rs.eis.service;


import org.springframework.stereotype.Service;

import com.rs.eis.model.Emp_awards;
import com.rs.eis.response.AddEmp_awardsResponse;
import com.rs.eis.response.DeleteEmp_awardsResponse;
import com.rs.eis.response.EditEmp_awardsResponse;
import com.rs.eis.response.GetAllEmp_awardsResponse;
import com.rs.eis.response.GetEmp_awardsResponse;

import javax.validation.Valid;

import com.rs.eis.model.Allocation;
import com.rs.eis.model.Country;
import com.rs.eis.model.State;
import com.rs.eis.request.AllocationVO;
import com.rs.eis.response.AddAllocationResponse;
import com.rs.eis.response.CountryResponse;
import com.rs.eis.response.DeleteAllocationResponse;
import com.rs.eis.response.DeleteCountryResponse;
import com.rs.eis.response.DeleteStateResponse;
import com.rs.eis.response.EditAllocationResponse;
import com.rs.eis.response.EditCountryResponse;
import com.rs.eis.response.EditStateResponse;
import com.rs.eis.response.GetAllocationResponse;
import com.rs.eis.response.GetAllocationsResponse;
import com.rs.eis.response.GetCountryResponse;
import com.rs.eis.response.GetStateResponse;
import com.rs.eis.response.StateResponse;



@Service
public interface EISService {

	GetEmp_awardsResponse getEmp_awardsByemployeeid(int employeeid);

	AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards);

	EditEmp_awardsResponse editEmp_awards(Emp_awards emp_awards);

	GetAllEmp_awardsResponse allEmp_awards(int employeeid);

	DeleteEmp_awardsResponse deleteEmp_awards(int id);


	CountryResponse addCountry(Country country);

	StateResponse addState(State state);

	GetStateResponse getStateById(int id);

	DeleteStateResponse deleteStateById(int id);

	EditStateResponse editState(State state);

	AddAllocationResponse addAllocation(AllocationVO allocationVO);

	EditAllocationResponse editAllocation(Allocation allocation);

	DeleteAllocationResponse deleteAllocation(int projectid);

	GetAllocationResponse getAllocationById(int id);

	GetAllocationsResponse getAllocations(int projectid);

	GetCountryResponse getCountryById(int id);

	DeleteCountryResponse deleteCountryById(int id);

	EditCountryResponse editCountry(@Valid Country country);

}
