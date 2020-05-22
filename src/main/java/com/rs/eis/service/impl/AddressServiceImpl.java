package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Country;
import com.rs.eis.model.State;
import com.rs.eis.repository.CountryRepository;
import com.rs.eis.repository.StateRepository;
import com.rs.eis.response.CountryResponse;
import com.rs.eis.response.DeleteCountryResponse;
import com.rs.eis.response.DeleteStateResponse;
import com.rs.eis.response.EditCountryResponse;
import com.rs.eis.response.EditStateResponse;
import com.rs.eis.response.GetCountryResponse;
import com.rs.eis.response.GetStateResponse;
import com.rs.eis.response.StateResponse;
import com.rs.eis.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired

	AddressService addressService;

	@Autowired

	CountryRepository countryRepository;

	@Autowired
	StateRepository stateRepository;

	public StateResponse addState(State state) {
		StateResponse response = new StateResponse();
		state = stateRepository.save(state);
		/* if (!state.isEmpty()) { */
		response.setState(state);
		response.setStatusCode("000");
		response.setStatus(HttpStatus.OK);
		/*
		 * } else { response.setStatusCode("001");
		 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
		 * setErrorMessage("Invalid Input as name is not present in state table"); }
		 */
		return response;
	}

	@Override
	public CountryResponse addCountry(Country country) {
		CountryResponse response = new CountryResponse();
		country = countryRepository.save(country);
		/* if (!state.isEmpty()) { */
		response.setCountry(country);
		response.setStatusCode("000");
		response.setStatus(HttpStatus.OK);
		/*
		 * } else { response.setStatusCode("001");
		 * response.setStatus(HttpStatus.PRECONDITION_FAILED); response.
		 * setErrorMessage("Invalid Input as name is not present in state table"); }
		 */
		return response;
	}

	@Override
	public GetStateResponse getStateById(int id) {
		GetStateResponse response = new GetStateResponse();
		Optional<State> state = stateRepository.findById(id);
		if (state.isPresent()) {
			response.setState(state.get());

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in user table");
		}

		return response;
	}
	
	
	@Override
	public DeleteStateResponse deleteStateById(int id) {
		DeleteStateResponse response = new DeleteStateResponse();
		Optional<State> state = stateRepository.findById(id);
		if (state.isPresent()) {
			State State = state.get();
			stateRepository.delete(State);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public EditStateResponse editState(State state) {
		EditStateResponse response = new EditStateResponse();
		Optional<State> stateObj = stateRepository.findById(state.getId());
		if (stateObj.isPresent()) {

			state = stateRepository.save(state);
			response.setState(state);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as name is not present in state table");

		}

		return response;
	}

	@Override

	public GetCountryResponse getCountryById(int id) {
		GetCountryResponse response = new GetCountryResponse();
		Optional<Country> country = countryRepository.findById(id);
		if (country.isPresent()) {
			response.setCountry(country.get());

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);

			response.setErrorMessage("No data Found for the given id");
		}
		return response;
	}

	@Override
	public DeleteCountryResponse deleteCountryById(int id) {
		DeleteCountryResponse response = new DeleteCountryResponse();
		Optional<Country> country = countryRepository.findById(id);
		if (country.isPresent()) {
			Country Country = country.get();
			countryRepository.delete(Country);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");

		}
		return response;
	}

	@Override

	public EditCountryResponse editCountry(Country country) {
		EditCountryResponse response = new EditCountryResponse();
		Optional<Country> countryObj = countryRepository.findById(country.getId());
		if (countryObj.isPresent()) {
			
			country=countryRepository.save(country);
			response.setCountry(country);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);

		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as name is not present in state table");
		}

		return response;

	}
}
