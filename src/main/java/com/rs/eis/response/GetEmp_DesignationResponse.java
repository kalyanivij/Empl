package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Designation;
import com.rs.eis.model.Emp_Designation;

public class GetEmp_DesignationResponse extends AbstractResponse {
	public GetEmp_DesignationResponse() {

	}

	public GetEmp_DesignationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Emp_Designation emp_designation;

	public Emp_Designation getEmp_designation() {
		return emp_designation;
	}

	public void setEmp_designation(Emp_Designation emp_designation) {
		this.emp_designation = emp_designation;
	}

	public void setEmp_designation(Designation designation) {
		// TODO Auto-generated method stub
		
	}

	
}
