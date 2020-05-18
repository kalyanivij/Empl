package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Technology;

public class TechnologyResponse extends AbstractResponse {
	public TechnologyResponse() {

	}

	public TechnologyResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Technology technology;

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
}
