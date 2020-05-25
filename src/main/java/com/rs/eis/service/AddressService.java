
package com.rs.eis.service;

import com.rs.eis.model.Country;
import com.rs.eis.model.State;
import com.rs.eis.response.CountryResponse;
import com.rs.eis.response.DeleteCountryResponse;
import com.rs.eis.response.DeleteStateResponse;
import com.rs.eis.response.EditCountryResponse;
import com.rs.eis.response.EditStateResponse;
import com.rs.eis.response.GetCountryResponse;
import com.rs.eis.response.GetStateResponse;
import com.rs.eis.response.StateResponse;

public interface AddressService {

	CountryResponse addCountry(Country country);

	StateResponse addState(State state);

	GetStateResponse getStateById(int id);

	DeleteStateResponse deleteStateById(int id);

	EditStateResponse editState(State state);

	GetCountryResponse getCountryById(int id);

	DeleteCountryResponse deleteCountryById(int id);

	EditCountryResponse editCountry(Country country);

	

}
