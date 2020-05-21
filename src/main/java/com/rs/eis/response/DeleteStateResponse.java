package com.rs.eis.response;


import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.State;


public class DeleteStateResponse extends AbstractResponse {
	public DeleteStateResponse() {

	}

	public DeleteStateResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

		
}



