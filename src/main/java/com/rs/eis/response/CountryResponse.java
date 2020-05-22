package com.rs.eis.response;

import com.rs.eis.model.Country;

public class CountryResponse extends AbstractResponse{
	
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	

}
