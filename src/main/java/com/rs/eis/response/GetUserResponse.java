package com.rs.eis.response;

import java.util.Set;


import org.springframework.http.HttpStatus;

import com.rs.eis.model.Employee;
import com.rs.eis.model.User;

public class GetUserResponse extends AbstractResponse {

	public GetUserResponse() {

	}

	public GetUserResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user2) {
		this.user = user2;
	}

}
