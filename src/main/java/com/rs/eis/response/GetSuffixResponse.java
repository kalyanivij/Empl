package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Suffix;
import com.rs.eis.response.AbstractResponse;

public class GetSuffixResponse extends AbstractResponse {
	
	public GetSuffixResponse() {

	}

	public GetSuffixResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Suffix suffix;

	public Suffix getSuffix() {
		return suffix;
	}

	public void setSuffix(Suffix suffix) {
		this.suffix = suffix;
	}

	
	
	}
