package com.rs.eis.response;


import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Country;


public class GetCountryResponse extends AbstractResponse {
	public GetCountryResponse() {

	}

	public GetCountryResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	private Country country;

		
}



