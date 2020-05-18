package com.rs.esi.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.esi.model.Emp_awards;
import com.rs.esi.model.Expense;

public class DeleteEmp_awardsResponse extends AbstractResponse {
private Emp_awards emp_awards;
	
	public Emp_awards getEmp_awards() {
		return emp_awards;
	}
	public void setEmp_awards(Emp_awards expense) {
		this.emp_awards = expense;
	}
	public DeleteEmp_awardsResponse() {

	}

	public DeleteEmp_awardsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
