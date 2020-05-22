package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Expense;
import com.rs.eis.model.Technology;

public class DeleteTechnologyResponse extends AbstractResponse {

	private Technology technology;

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public DeleteTechnologyResponse() {

	}

	public DeleteTechnologyResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}
