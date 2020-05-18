package com.rs.eis.service;

import com.rs.eis.model.Family;
import com.rs.eis.model.Insurance;
import com.rs.eis.request.UserVO;
import com.rs.eis.response.AddFamilyResponse;
import com.rs.eis.response.AddInsuranceResponse;
import com.rs.eis.response.DeleteFamilyResponse;
import com.rs.eis.response.DeleteInsuranceResponse;
import com.rs.eis.response.GetFamilyResponse;
import com.rs.eis.response.GetInsuranceResponse;
import com.rs.eis.response.LoginResponse;
import com.rs.eis.response.ResetPasswordResponse;
import com.rs.eis.response.UpdateUserResponse;

public interface FERService {

	LoginResponse login(String userName, String password);


	ResetPasswordResponse resetPassword(int userid, String currentPassword, String newPassword);

	
	UpdateUserResponse updateUser(UserVO userVO);
	
	
	DeleteInsuranceResponse deleteinsurance  (int employeeid);



	GetInsuranceResponse getInsuranceByemployeeid(int employeeid);
	GetInsuranceResponse insuranceReport(int employeeid);

	AddInsuranceResponse addInsurance(Insurance insurance);
	
	
	GetFamilyResponse getFamilyByemployeeid(int employeeid);
	GetFamilyResponse familyReport(int employeeid);

	DeleteFamilyResponse deleteFamily(int employeeid);
	AddFamilyResponse addfamily(Family family);


}
