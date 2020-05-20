package com.rs.esi.validation;

import java.util.Set;

import com.rs.esi.request.RegistrationVO;
import com.rs.esi.request.UserVO;

public interface ValidationUtil {
	
	
	/*
	 * Set<String> validateEmp_awardsReportRequest(int employeeid);
	 */
	Set<String> validateDeleteEpm_awardsRequest(int id);

	Set<String> validateGetEmp_awardsRequest(int id);
	
	
}
