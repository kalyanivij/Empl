package com.rs.eis.service;

import com.rs.eis.model.Allocation;
import com.rs.eis.model.Family;
import com.rs.eis.model.Insurance;
import com.rs.eis.response.AddAllocationResponse;
import com.rs.eis.response.AddFamilyResponse;
import com.rs.eis.response.AddInsuranceResponse;
import com.rs.eis.response.DeleteAllocationResponse;
import com.rs.eis.response.DeleteFamilyResponse;
import com.rs.eis.response.DeleteInsuranceResponse;
import com.rs.eis.response.EditAllocationResponse;
import com.rs.eis.response.EditFamilyResponse;
import com.rs.eis.response.EditInsuranceResponse;
import com.rs.eis.response.GetAllocationResponse;
import com.rs.eis.response.GetAllocationsResponse;
import com.rs.eis.response.GetFamilyResponse;
import com.rs.eis.response.GetInsuranceResponse;

public interface EISService {

	
	
	DeleteInsuranceResponse deleteinsurance  (int employeeid);

	GetInsuranceResponse getInsuranceByemployeeid(int employeeid);
	GetInsuranceResponse insuranceReport(int employeeid);

	AddInsuranceResponse addInsurance(Insurance insurance);
	EditInsuranceResponse editInsurance(Insurance insurance);
	EditFamilyResponse editFamily(Family family);

	
	GetFamilyResponse getFamilyByemployeeid(int employeeid);
	GetFamilyResponse familyReport(int employeeid);

	DeleteFamilyResponse deleteFamily(int employeeid);
	AddFamilyResponse addFamily(Family family);
	
	

	AddAllocationResponse addAllocation(Allocation allocation);
	
	EditAllocationResponse editAllocation(Allocation allocation);
	
	DeleteAllocationResponse deleteAllocation(int projectid);
	
	GetAllocationResponse getAllocationById(int id);
	
	GetAllocationsResponse getAllocations(int projectid);


}
