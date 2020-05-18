package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.model.Experience;

public class ExperienceResponse extends AbstractResponse {
	public ExperienceResponse() {

	}

	public ExperienceResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Experience experience;

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

}
