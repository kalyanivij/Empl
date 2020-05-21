package com.rs.eis.response;


import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.State;


public class GetStateResponse extends AbstractResponse {
	public GetStateResponse() {

	}

	public GetStateResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
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



