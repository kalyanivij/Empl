package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.EmpAssets;
import com.rs.eis.model.Expense;

public class AddAssetsResponse extends AbstractResponse {

	private List<EmpAssets> employeeAssets;

	public AddAssetsResponse() {
		
	}
                
	public AddAssetsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

//	public List<EmpAssets> getEmpAssets() {
//		return expenses;
//	}

	public List<EmpAssets> getEmpAssets() {
		return employeeAssets;
	}
                                                                     
	public void setEmpAssets(List<EmpAssets> employeeAssets) {
		this.employeeAssets = employeeAssets;
	}

}
