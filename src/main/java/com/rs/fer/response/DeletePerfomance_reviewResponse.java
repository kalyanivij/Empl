package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Perfomance_Review;
import com.rs.fer.model.Expense;

public class DeletePerfomance_reviewResponse extends AbstractResponse {
private Perfomance_Review emp_awards;
	
	public Perfomance_Review getEmp_awards() {
		return emp_awards;
	}
	public void setEmp_awards(Perfomance_Review expense) {
		this.emp_awards = expense;
	}
	public DeletePerfomance_reviewResponse() {

	}

	public DeletePerfomance_reviewResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
