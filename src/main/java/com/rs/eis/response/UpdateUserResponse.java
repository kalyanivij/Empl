package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

<<<<<<< HEAD
import com.rs.eis.model.User;

public class UpdateUserResponse extends AbstractResponse {

	private User user;

	public UpdateUserResponse() {

	}

	public UpdateUserResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
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

=======

public class UpdateUserResponse extends AbstractResponse {

	/*
	 * private User user;
	 * 
	 * public UpdateUserResponse() {
	 * 
	 * }
	 * 
	 * public UpdateUserResponse(HttpStatus status, String statusCode, Set<String>
	 * errorMessages) { super.setStatus(status); super.setStatusCode(statusCode);
	 * super.setErrorMessages(errorMessages); }
	 * 
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
}
