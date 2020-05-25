package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Country;
import com.rs.eis.model.State;
import com.rs.eis.repository.AddressRepository;
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
import com.rs.eis.validation.AddressValidationUtil;

@RestController
@RequestMapping("/eis")
public class AddressController {

	@Autowired
	AddressService addressService;

	@Autowired
	AddressValidationUtil addressValidationUtil;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CountryRepository countryRepository;

	@PostMapping("/state")
	public StateResponse addState(@Valid @RequestBody State state) {
		return addressService.addState(state);
	}

	@GetMapping("/state/{id}")
	public GetStateResponse getStateById(@PathVariable("id") int id) {
		Set<String> errorMessages = addressValidationUtil.validateStateRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetStateResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return addressService.getStateById(id);
		}
	}

	@DeleteMapping("/state/{id}")
	public DeleteStateResponse deleteStateById(@PathVariable("id") int id) {
		Set<String> errorMessages = addressValidationUtil.validateStateRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteStateResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return addressService.deleteStateById(id);
		}
	}

	@PutMapping("/state/{id}")
	public EditStateResponse editState(@PathVariable("id") int id, @Valid @RequestBody State state) {

		return addressService.editState(state);

	}

	@PostMapping("/country")
	public CountryResponse addCountry(@Valid @RequestBody Country country) {

		return addressService.addCountry(country);
	}

	@GetMapping("/country/{id}")
	public GetCountryResponse getCountryById(@PathVariable("id") int id) {
		Set<String> errorMessages = addressValidationUtil.validateStateRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetCountryResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return addressService.getCountryById(id);
		}
	}

	@DeleteMapping("/country/{id}")
	public DeleteCountryResponse deleteCountryById(@PathVariable("id") int id) {
		Set<String> errorMessages = addressValidationUtil.validateStateRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteCountryResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return addressService.deleteCountryById(id);
		}
	}

	@PutMapping("/country/{id}")
	public EditCountryResponse editCountry(@PathVariable("id") int id, @Valid @RequestBody Country country) {

		return addressService.editCountry(country);

	}

}
