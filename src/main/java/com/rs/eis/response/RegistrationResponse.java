package com.rs.eis.response;

import java.util.Set;


import org.springframework.http.HttpStatus;

import com.rs.eis.model.User;

public class RegistrationResponse extends AbstractResponse {

	private User user;

	public RegistrationResponse() {

	}

	public RegistrationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
